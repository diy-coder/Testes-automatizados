package com.br.digitalMarketPlace.modules.clients.application.rest.controllers;

import com.br.digitalMarketPlace.modules.clients.application.rest.controllers.generics.RestBasicController;
import com.br.digitalMarketPlace.modules.clients.domain.dtos.IClientDTO;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;
import com.br.digitalMarketPlace.modules.clients.domain.services.impl.ClientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientsController extends RestBasicController<Client, IClientDTO> {

    @Autowired
    public ClientsController(ClientsServiceImpl clientsService) {
        super(clientsService);
    }

}

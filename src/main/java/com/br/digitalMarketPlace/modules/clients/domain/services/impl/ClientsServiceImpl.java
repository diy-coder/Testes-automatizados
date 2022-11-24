package com.br.digitalMarketPlace.modules.clients.domain.services.impl;

import com.br.digitalMarketPlace.modules.clients.domain.dtos.IClientDTO;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;
import com.br.digitalMarketPlace.modules.clients.domain.enums.ExceptionEnum;
import com.br.digitalMarketPlace.modules.clients.domain.services.CrudService;
import com.br.digitalMarketPlace.modules.clients.infrastructure.repositories.mysql.SpringDataH2ClientsRepository;
import com.br.digitalMarketPlace.shared.exceptions.AppError;
import com.br.digitalMarketPlace.shared.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientsServiceImpl implements CrudService<Client, IClientDTO> {
    private final SpringDataH2ClientsRepository clientsRepository;

    @Autowired
    public ClientsServiceImpl(SpringDataH2ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @Override
    public String createItem(IClientDTO clientDTO) {
        final Client client = new Client();
        client.setId(UUID.randomUUID().toString());
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setEmail(clientDTO.getEmail());
        client.setDateOfBirth(clientDTO.getDateOfBirth());
        client.setCpf(clientDTO.getCpf());

        clientsRepository.save(client);
        return client.getId();
    }

    @Override
    public List<Client> listItems() {
        return clientsRepository.findAll();
    }

    @Override
    public Client showItem(String id) {
        return clientsRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException(ExceptionEnum.CUSTOMER_NOT_FOUND));
    }

    @Override
    public void updateItem(String id, IClientDTO clientDTO) {
        Client client = clientsRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException(ExceptionEnum.CUSTOMER_NOT_FOUND));

        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setEmail(clientDTO.getEmail());
        client.setDateOfBirth(clientDTO.getDateOfBirth());
        client.setCpf(clientDTO.getCpf());

        clientsRepository.save(client);
    }

    @Override
    public void deleteItem(String id) {
        Client client = clientsRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException(ExceptionEnum.CUSTOMER_NOT_FOUND));

        clientsRepository.delete(client);
    }
}

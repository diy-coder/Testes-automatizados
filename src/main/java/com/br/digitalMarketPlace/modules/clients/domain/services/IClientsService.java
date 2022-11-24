package com.br.digitalMarketPlace.modules.clients.domain.services;

import java.util.List;

import com.br.digitalMarketPlace.modules.clients.domain.dtos.IClientDTO;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;

public interface IClientsService {
	String createClient(IClientDTO client);
	List<Client> listClients();
	Client showClient(String id);
	void updateClient(String id, IClientDTO client);
	void deleteClient(String id);
}

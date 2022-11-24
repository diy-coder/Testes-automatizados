package com.br.digitalMarketPlace.modules.clients.domain.repositories;
import java.util.List;
import java.util.Optional;

import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;

public interface IClientsRepository {
	Optional<Client> findById(String id);
	List<Client> findAllClients();
	void save(Client client);
	void delete(Client client);
	
}

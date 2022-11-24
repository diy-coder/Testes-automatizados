package com.br.digitalMarketPlace.modules.clients.infrastructure.repositories.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Product;
import com.br.digitalMarketPlace.modules.clients.domain.repositories.IClientsRepository;
import com.br.digitalMarketPlace.modules.clients.domain.repositories.IProductsRepository;

@Component
@Primary
public class H2IClientRepository implements IClientsRepository {
	private final SpringDataH2ClientsRepository clientsRepository;

	public H2IClientRepository(SpringDataH2ClientsRepository clientsRepository) {
		super();
		this.clientsRepository = clientsRepository;
	}

	@Override
	public Optional<Client> findById(final String id) {
		// TODO Auto-generated method stub
		return clientsRepository.findById(id);
	}

	@Override
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return clientsRepository.findAll();
	}

	@Override
	public void save(Client client) {
		clientsRepository.save(client);
	}

	@Override
	public void delete(Client client) {
		clientsRepository.delete(client);
	}

}

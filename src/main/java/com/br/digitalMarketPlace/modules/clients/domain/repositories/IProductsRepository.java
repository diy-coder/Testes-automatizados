package com.br.digitalMarketPlace.modules.clients.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Product;

public interface IProductsRepository {
	Optional<Product> findById(String id);
	List<Product> findAllProducts();
	void save(Product product);
	void delete(Product product);
	
}

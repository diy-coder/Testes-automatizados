package com.br.digitalMarketPlace.modules.clients.infrastructure.repositories.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.br.digitalMarketPlace.modules.clients.domain.entities.Product;
import com.br.digitalMarketPlace.modules.clients.domain.repositories.IProductsRepository;

@Component
@Primary
public class H2IProductRepository implements IProductsRepository {
	private final SpringDataH2ProductsRepository productsRepository;

	public H2IProductRepository(SpringDataH2ProductsRepository productsRepository) {
		super();
		this.productsRepository = productsRepository;
	}

	@Override
	public Optional<Product> findById(final String id) {

		return productsRepository.findById(id);
	}

	@Override
	public List<Product> findAllProducts() {
			
		return productsRepository.findAll();
	}

	@Override
	public void save(final Product product) {
		 productsRepository.save(product);
	}

	@Override
	public void delete(Product product) {
		productsRepository.delete(product);

	}

}

package com.br.digitalMarketPlace.modules.clients.domain.services;

import java.util.List;

import com.br.digitalMarketPlace.modules.clients.domain.dtos.IProductDTO;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Product;
import com.br.digitalMarketPlace.modules.clients.domain.repositories.IProductsRepository;

public class ProductServiceImpl implements IProductService {
	
	private final IProductsRepository productsRepository;
	
	
	
	public ProductServiceImpl(IProductsRepository productsRepository) {
		super();
		this.productsRepository = productsRepository;
	}

	@Override
	public String createProduct(IProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		return productsRepository.findAllProducts();
	}

	@Override
	public Product showClient(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(String id, IProductDTO product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub
		
	}

}

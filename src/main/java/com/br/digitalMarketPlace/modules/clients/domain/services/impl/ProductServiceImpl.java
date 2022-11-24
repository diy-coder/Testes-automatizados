package com.br.digitalMarketPlace.modules.clients.domain.services.impl;

import com.br.digitalMarketPlace.modules.clients.domain.dtos.IProductDTO;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Product;
import com.br.digitalMarketPlace.modules.clients.domain.services.CrudService;
import com.br.digitalMarketPlace.modules.clients.infrastructure.repositories.mysql.SpringDataH2ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements CrudService<Product, IProductDTO> {

    private final SpringDataH2ProductsRepository productsRepository;

    @Autowired
    public ProductServiceImpl(SpringDataH2ProductsRepository productsRepository) {
        super();
        this.productsRepository = productsRepository;
    }

    @Override
    public String createItem(IProductDTO product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> listItems() {
        // TODO Auto-generated method stub
        return productsRepository.findAll();
    }

    @Override
    public Product showItem(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateItem(String id, IProductDTO product) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteItem(String id) {
        // TODO Auto-generated method stub

    }

}

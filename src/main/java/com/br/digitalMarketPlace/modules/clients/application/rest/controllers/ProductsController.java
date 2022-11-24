package com.br.digitalMarketPlace.modules.clients.application.rest.controllers;

import com.br.digitalMarketPlace.modules.clients.application.rest.controllers.generics.RestBasicController;
import com.br.digitalMarketPlace.modules.clients.domain.dtos.IProductDTO;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Product;
import com.br.digitalMarketPlace.modules.clients.domain.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@Validated
public class ProductsController extends RestBasicController<Product, IProductDTO> {

    @Autowired
    public ProductsController(ProductServiceImpl productService) {
        super(productService);
    }
}

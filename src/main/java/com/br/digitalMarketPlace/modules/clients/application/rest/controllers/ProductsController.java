package com.br.digitalMarketPlace.modules.clients.application.rest.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.digitalMarketPlace.modules.clients.domain.dtos.IClientDTO;
import com.br.digitalMarketPlace.modules.clients.domain.dtos.IProductDTO;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Product;
import com.br.digitalMarketPlace.modules.clients.domain.services.IProductService;
import com.br.digitalMarketPlace.shared.exceptions.AppError;

@RestController
@RequestMapping("/products")
@Validated
public class ProductsController {

	private final IProductService productService;

	public ProductsController(IProductService productService) {
		super();
		this.productService = productService;
	}

	public ProductsController() {
		this.productService = null;

	}

	@GetMapping
	public List<Product> index() {
		return productService.listProducts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> show(@PathVariable String id) {
		try {
			Product product = productService.showClient(id);
			return ResponseEntity.ok(product);

		} catch (AppError e) {
			return ResponseEntity.notFound().build();

		}
	}

	@PostMapping
	public ResponseEntity<String> create(@Valid @RequestBody IProductDTO productDTO) {
		final String id = productService.createProduct(productDTO);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@Valid @PathVariable String id, @RequestBody IProductDTO product) {
		try {
			productService.updateProduct(id, product);
			return ResponseEntity.noContent().build();
		} catch (AppError e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		try {
			productService.deleteProduct(id);
			return ResponseEntity.noContent().build();
		} catch (AppError e) {
			return ResponseEntity.notFound().build();
		}
	}
}

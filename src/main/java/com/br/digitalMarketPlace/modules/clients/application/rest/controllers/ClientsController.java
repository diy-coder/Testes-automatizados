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
import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;
import com.br.digitalMarketPlace.modules.clients.domain.services.IClientsService;
import com.br.digitalMarketPlace.shared.exceptions.AppError;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientsController {

	private final IClientsService clientsService;

	public ClientsController(IClientsService clientsService) {
		this.clientsService = clientsService;
	}

	@GetMapping
	public List<Client> index() {
		return clientsService.listClients();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> show(@PathVariable String id) {
		try {
			Client client = clientsService.showClient(id);
			return ResponseEntity.ok(client);
		} catch (AppError e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<String> create(@Valid @RequestBody IClientDTO clientDTO) {
		final String id = clientsService.createClient(clientDTO);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(id).toUri();

			return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@Valid @PathVariable String id, @RequestBody IClientDTO client) {
		try {
			clientsService.updateClient(id, client);
			return ResponseEntity.noContent().build();
		} catch (AppError e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		try {
			clientsService.deleteClient(id);
			return ResponseEntity.noContent().build();
		} catch (AppError e) {
			return ResponseEntity.notFound().build();
		}
	}
}

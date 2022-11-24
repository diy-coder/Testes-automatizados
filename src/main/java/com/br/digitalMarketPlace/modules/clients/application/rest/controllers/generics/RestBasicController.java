package com.br.digitalMarketPlace.modules.clients.application.rest.controllers.generics;

import com.br.digitalMarketPlace.modules.clients.domain.services.CrudService;
import com.br.digitalMarketPlace.shared.exceptions.AppError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

public class RestBasicController<T, D> {

    private final CrudService<T, D> service;

    public RestBasicController(CrudService<T, D> service) {
        this.service = service;
    }

    @GetMapping
    public List<T> getAll() {
        return service.listItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable String id) {
        try {
            T model = service.showItem(id);
            return ResponseEntity.ok(model);

        } catch (AppError e) {
            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody D objDTO) {
        final String id = service.createItem(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@Valid @PathVariable String id, @RequestBody D objDTO) {
        service.updateItem(id, objDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}

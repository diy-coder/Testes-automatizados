package com.br.digitalMarketPlace.modules.clients.domain.services;

import java.util.List;

public interface CrudService<T, D> {
    String createItem(D itemDTO);

    List<T> listItems();

    T showItem(String id);

    void updateItem(String id, D itemDTO);

    void deleteItem(String id);
}

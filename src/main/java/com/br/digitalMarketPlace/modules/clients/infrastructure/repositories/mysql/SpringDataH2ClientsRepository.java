package com.br.digitalMarketPlace.modules.clients.infrastructure.repositories.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Product;
@Repository
public interface SpringDataH2ClientsRepository extends JpaRepository<Client, String>{

}

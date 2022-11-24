package com.br.digitalMarketPlace.modules.clients.infrastructure.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.br.digitalMarketPlace.modules.clients.infrastructure.repositories.mysql.SpringDataH2ProductsRepository;

@EnableJpaRepositories(basePackageClasses = SpringDataH2ProductsRepository.class)
public class MySqlDbConfiguration {
}

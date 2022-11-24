package com.br.digitalMarketPlace.modules.clients.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.br.digitalMarketPlace.DigitalMarketPlaceApplication;
import com.br.digitalMarketPlace.modules.clients.domain.repositories.IClientsRepository;
import com.br.digitalMarketPlace.modules.clients.domain.services.ClientsServiceImpl;
import com.br.digitalMarketPlace.modules.clients.domain.services.IClientsService;

@Configuration
@ComponentScan(basePackageClasses = DigitalMarketPlaceApplication.class)
public class BeanConfiguration {
  
  @Bean
  IClientsService clientsService(final IClientsRepository clientsRepository) {
    return new ClientsServiceImpl(clientsRepository);
  }
}

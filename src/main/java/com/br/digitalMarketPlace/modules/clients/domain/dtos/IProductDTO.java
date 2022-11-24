package com.br.digitalMarketPlace.modules.clients.domain.dtos;

import javax.validation.constraints.NotBlank;

import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;

public class IProductDTO {

	@NotBlank
	private String name;
	
	@NotBlank
	private int qtd;
	
	@NotBlank
	private double price;
	
	@NotBlank
	private Client clients;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Client getClients() {
		return clients;
	}
	public void setClients(Client clients) {
		this.clients = clients;
	}
	
	
}

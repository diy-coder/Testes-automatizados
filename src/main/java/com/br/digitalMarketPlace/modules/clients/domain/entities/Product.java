package com.br.digitalMarketPlace.modules.clients.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private int qtd;
    private double price;
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client clients;

    @Override
    public int hashCode() {
        return Objects.hash(clients, id, name, price, qtd);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        return Objects.equals(clients, other.clients) && Objects.equals(id, other.id)
                && Objects.equals(name, other.name)
                && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && qtd == other.qtd;
    }

}

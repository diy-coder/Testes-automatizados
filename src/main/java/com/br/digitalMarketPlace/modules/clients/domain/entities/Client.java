package com.br.digitalMarketPlace.modules.clients.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String cpf;
    @OneToMany
    private List<Product> product;

    @Override
    public int hashCode() {
        return Objects.hash(cpf, dateOfBirth, email, firstName, id, lastName, product);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        return Objects.equals(cpf, other.cpf) && Objects.equals(dateOfBirth, other.dateOfBirth)
                && Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
                && Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
                && Objects.equals(product, other.product);
    }

}

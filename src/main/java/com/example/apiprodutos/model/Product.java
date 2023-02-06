package com.example.apiprodutos.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotEmpty
    @Size(max = 65)
    private String name;
    @NotNull
    @Max(100000000)
    private Double price;
    @NotNull
    @Max(100000000)
    private int quantity;
    @Size(max = 350)
    private String description;

    public Product(){
    }

    public Product(UUID id, String name, Double price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product produtos = (Product) o;
        return quantity == produtos.quantity && id.equals(produtos.id) && Objects.equals(name, produtos.name) && Objects.equals(price, produtos.price) && Objects.equals(description, produtos.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity, description);
    }
}

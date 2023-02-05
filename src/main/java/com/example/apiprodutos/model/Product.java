package com.example.apiprodutos.model;

import java.util.Objects;

public class Produtos {

    private Long id;
    private String name;
    private Double price;
    private int quantity;
    private String description;

    public Produtos(Long id, String name, Double price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        Produtos produtos = (Produtos) o;
        return quantity == produtos.quantity && id.equals(produtos.id) && Objects.equals(name, produtos.name) && Objects.equals(price, produtos.price) && Objects.equals(description, produtos.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity, description);
    }
}

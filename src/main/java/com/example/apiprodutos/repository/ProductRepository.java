package com.example.apiprodutos.repository;

import com.example.apiprodutos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

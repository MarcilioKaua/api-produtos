package com.example.apiprodutos.controller;

import com.example.apiprodutos.model.Product;
import com.example.apiprodutos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public ResponseEntity<Object> findProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }
}

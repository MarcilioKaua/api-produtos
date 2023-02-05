package com.example.apiprodutos.controller;

import com.example.apiprodutos.model.Product;
import com.example.apiprodutos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public ResponseEntity<Object> findProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findProductById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product Deleted");
    }
}

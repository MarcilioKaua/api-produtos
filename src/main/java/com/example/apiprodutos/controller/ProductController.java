package com.example.apiprodutos.controller;

import com.example.apiprodutos.model.Product;
import com.example.apiprodutos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

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
    public ResponseEntity<Object> findProductById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveProduct(@Valid @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(@Valid @PathVariable UUID id, @RequestBody Product product){
        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        product.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable UUID id){
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product Deleted");
    }
}

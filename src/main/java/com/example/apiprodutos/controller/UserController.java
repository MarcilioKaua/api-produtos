package com.example.apiprodutos.controller;

import com.example.apiprodutos.model.Product;
import com.example.apiprodutos.model.User;
import com.example.apiprodutos.repository.ProductRepository;
import com.example.apiprodutos.repository.UserRepository;
import com.example.apiprodutos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<Object> findProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findProductById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveProduct(@Valid @RequestBody User user){
        User userUtil = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userUtil);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(@Valid @PathVariable Long id, @RequestBody User user){
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("User Deleted");
    }
}


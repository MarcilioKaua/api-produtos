package com.example.apiprodutos.service;

import com.example.apiprodutos.model.User;
import com.example.apiprodutos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(User user){
        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(pass));
        userRepository.save(user);
    }
}

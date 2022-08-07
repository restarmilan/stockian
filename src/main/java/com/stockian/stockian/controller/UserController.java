package com.stockian.stockian.controller;

import com.stockian.stockian.entity.StockianUser;
import com.stockian.stockian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<StockianUser> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StockianUser createUser (@Validated @RequestBody StockianUser user) {
        return userRepository.save(user);
    }
}

package com.stockian.stockian.controller;

import com.stockian.stockian.entity.StockianUser;
import com.stockian.stockian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/user/{userName}")
    public ResponseEntity<StockianUser> getUserByName(@PathVariable("userName") String userName)
        throws Exception {
        StockianUser stockianUser = userRepository.findStockianUserByUserName(userName);
        if (stockianUser == null) {
            throw new Exception("User " + userName + " not found");
        }
        return ResponseEntity.ok().body(stockianUser);
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StockianUser createUser (@RequestBody StockianUser user) {
        return userRepository.save(user);
    }
}

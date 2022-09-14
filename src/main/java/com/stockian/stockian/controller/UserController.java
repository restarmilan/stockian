package com.stockian.stockian.controller;

import com.stockian.stockian.constants.enums.UserStatus;
import com.stockian.stockian.entity.StockianUser;
import com.stockian.stockian.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
      throw new Exception("User" + userName + " not found");
    }
    return ResponseEntity.ok().body(stockianUser);
  }

  @GetMapping("/users/{status}")
  public ResponseEntity<List<StockianUser>> getUsersByStatus(
      @PathVariable("status") UserStatus status)
      throws Exception {
    List<StockianUser> stockianUsersByStatus = userRepository.findStockianUsersByStatus(status);
    if (stockianUsersByStatus == null) {
      throw new Exception("Users with " + status.toString() + " not found");
    }
    return ResponseEntity.ok().body(stockianUsersByStatus);
  }

  @GetMapping("/user/{userName}/status")
  public ResponseEntity<String> getStatusByUser(@PathVariable("userName") String userName)
      throws Exception {
    StockianUser stockianUser = userRepository.findStockianUserByUserName(userName);
    if (stockianUser == null) {
      throw new Exception("User" + userName + " not found");
    }
    return ResponseEntity.ok().body(stockianUser.getStatus().toString());

  }

  @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
  public StockianUser createUser(@RequestBody StockianUser user) {
    user.setStatus(UserStatus.PENDING);
    return userRepository.save(user);
  }

  @PostMapping(value = "/setStatus", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> setUserStatus(@RequestBody StockianUser user) {
    StockianUser stockianUser = userRepository.findStockianUserByUserName(user.getUserName());
    stockianUser.setStatus(user.getStatus());
    userRepository.save(stockianUser);
    return ResponseEntity.ok().body("Success");
  }
}

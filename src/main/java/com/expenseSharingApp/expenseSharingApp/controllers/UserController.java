package com.expenseSharingApp.expenseSharingApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expenseSharingApp.expenseSharingApp.dtos.UserDTO;
import com.expenseSharingApp.expenseSharingApp.entities.User;
import com.expenseSharingApp.expenseSharingApp.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping()
  public ResponseEntity<List<User>> listUsers() {
    List<User> users = userService.listUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }
  
  @GetMapping("/me")
  public ResponseEntity<User> me(@RequestParam String id) throws Exception {
    User me = userService.me(id);
    return new ResponseEntity<>(me, HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<User> create(@RequestBody UserDTO user) {
    User newUser = userService.create(user);
    return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
  }
}

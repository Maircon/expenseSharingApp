package com.expenseSharingApp.expenseSharingApp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/followers")
public class FollowersController {
  @GetMapping()
  public ResponseEntity<String> getAll() {
    return new ResponseEntity<String>("HELLO", HttpStatus.OK);
  }
}

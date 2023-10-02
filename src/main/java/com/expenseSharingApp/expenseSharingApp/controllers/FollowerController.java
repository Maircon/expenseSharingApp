package com.expenseSharingApp.expenseSharingApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseSharingApp.expenseSharingApp.entities.Follower;

@RestController()
@RequestMapping("/followers")
public class FollowerController {
  @GetMapping()
  public ResponseEntity<List<Follower>> getAll() {
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
  }
}

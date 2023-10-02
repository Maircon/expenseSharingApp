package com.expenseSharingApp.expenseSharingApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expenseSharingApp.expenseSharingApp.dtos.WalletDTO;
import com.expenseSharingApp.expenseSharingApp.entities.User;
import com.expenseSharingApp.expenseSharingApp.entities.Wallet;
import com.expenseSharingApp.expenseSharingApp.services.UserService;
import com.expenseSharingApp.expenseSharingApp.services.WalletService;

@RestController
@RequestMapping("/wallets")
public class WalletController {
  @Autowired
  private WalletService walletService;

  @Autowired
  private UserService userService;

  @RequestMapping
  public ResponseEntity<Wallet> getOne(@RequestParam String idUser) throws Exception {
    User user = userService.me(idUser);
    Wallet wallet = walletService.getOne(user);
    return new ResponseEntity<>(wallet, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Wallet> create(@RequestBody WalletDTO walletDto) throws Exception {
    User user = userService.me(walletDto.idUser());
    Wallet wallet = walletService.create(user, walletDto);
    return new ResponseEntity<>(wallet, HttpStatus.OK);
  }
}

package com.expenseSharingApp.expenseSharingApp.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseSharingApp.expenseSharingApp.dtos.WalletDTO;
import com.expenseSharingApp.expenseSharingApp.entities.User;
import com.expenseSharingApp.expenseSharingApp.entities.Wallet;
import com.expenseSharingApp.expenseSharingApp.repositories.WalletRepository;

@Service
public class WalletService {
  @Autowired
  private WalletRepository walletRepository;

  public Wallet getOne(User user) throws Exception {
    return walletRepository.getWalletByUserId(user.getId()).orElseThrow(() -> new Exception("Not found wallet"));
  }

  public Wallet create(User user, WalletDTO walletDTO) {
    Wallet wallet = new Wallet();

    wallet.setUser(user);
    wallet.setBalance(walletDTO.balance());

    return walletRepository.save(wallet);
  }
}

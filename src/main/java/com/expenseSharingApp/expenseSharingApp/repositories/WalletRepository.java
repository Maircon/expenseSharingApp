package com.expenseSharingApp.expenseSharingApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.expenseSharingApp.expenseSharingApp.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, String> {
  public Optional<Wallet> getWalletByUserId(String id);
}

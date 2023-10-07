package com.expenseSharingApp.expenseSharingApp.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "wallets")
@Table(name = "wallets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_wallet")
  private String id;

  @Column(name = "balance")
  private BigDecimal balance;
  
  @OneToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id_user")
  private User user;
}

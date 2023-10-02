package com.expenseSharingApp.expenseSharingApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "followers")
@Table(name = "followers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Follower {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String idUser;
  private String idFollower;
}

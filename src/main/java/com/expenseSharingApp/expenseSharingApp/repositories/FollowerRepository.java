package com.expenseSharingApp.expenseSharingApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenseSharingApp.expenseSharingApp.entities.Follower;

public interface FollowerRepository extends JpaRepository<Follower, String> {
  public List<Follower> findAll();
}

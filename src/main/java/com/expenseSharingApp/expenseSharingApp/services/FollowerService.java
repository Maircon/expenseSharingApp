package com.expenseSharingApp.expenseSharingApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseSharingApp.expenseSharingApp.entities.Follower;
import com.expenseSharingApp.expenseSharingApp.repositories.FollowerRepository;

@Service
public class FollowerService {

  @Autowired
  private FollowerRepository followerRepository;

  public List<Follower> getAll() {
    return followerRepository.findAll();
  }
}

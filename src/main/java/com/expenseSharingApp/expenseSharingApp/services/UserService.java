package com.expenseSharingApp.expenseSharingApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseSharingApp.expenseSharingApp.dtos.UserDTO;
import com.expenseSharingApp.expenseSharingApp.entities.User;
import com.expenseSharingApp.expenseSharingApp.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User me(String id) throws Exception {

    return userRepository.findById(id).orElseThrow(() -> new Exception("Not found user"));

    // Optional<User> me = userRepository.findById(id);

    // if (me.isEmpty()) {
    //   throw new Exception("Not exists");
    // }

    // return me.get();
  }

  public User create(UserDTO user) {
    User newUser = new User();

    newUser.setName(user.name());
    newUser.setEmail(user.email());
    newUser.setPassword(user.password());

    return userRepository.save(newUser);
  }

  public List<User> listUsers() {
    return userRepository.findAll();
  }
}

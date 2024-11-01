package org.example.minisns.user.service;

import lombok.RequiredArgsConstructor;
import org.example.minisns.user.domain.User;
import org.example.minisns.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
  private final UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }
}

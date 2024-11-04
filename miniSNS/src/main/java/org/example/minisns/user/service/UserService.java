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

  @Transactional(readOnly = true)
  public User getUserByUserId(String userId) {
    return userRepository.findByUserId(userId);
  }

  public void removeUser(String userId) {
    userRepository.deleteByUserId(userId);
  }

  public void changePassword(String userId, User user) {
    User oldUser = getUserByUserId(userId);
    oldUser.setPassword(user.getPassword());
    userRepository.save(oldUser);
  }

  public List<User> getUserList() {
    return userRepository.findByUserIdAndUserName("asdf", "dddd");

  }
}

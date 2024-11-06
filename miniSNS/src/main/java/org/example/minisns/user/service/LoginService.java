package org.example.minisns.user.service;

import lombok.RequiredArgsConstructor;
import org.example.minisns.user.domain.User;
import org.example.minisns.user.domain.UserLoginDto;
import org.example.minisns.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {
  private final UserRepository userRepository;

  public User login(UserLoginDto userLoginDto) {
    User user = userRepository.findByUserId(userLoginDto.getUserId());
    if (user != null && user.getPassword().equals(userLoginDto.getPassword())) {
      return user;
    } else {
      return null;
    }
  }
}

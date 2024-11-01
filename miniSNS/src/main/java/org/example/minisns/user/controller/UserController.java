package org.example.minisns.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.minisns.user.domain.User;
import org.example.minisns.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  // alt + enter 누르면 없는 함수도 바로 만들어줌
  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }
}

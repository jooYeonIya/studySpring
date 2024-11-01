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

  @GetMapping("/{userId}")
  public User getUser(@PathVariable("userId") String userId) {
    return userService.getUserByUserId(userId);
  }

  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable("userId") String userId) {
    userService.removeUser(userId);
  }

  @PutMapping("/{userId}")
  public void updateUser(@PathVariable("userId") String userId, @RequestBody User user) {
    userService.changePassword(userId, user);
  }
}

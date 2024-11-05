package org.example.filter_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class LoginController {

  @GetMapping("/register")
  public String register() {
    return "회원 가입 완료";
  }

  @GetMapping("/login")
  public String login() {
    return "로그인 완료";
  }
}

package org.example.security.controller;

import lombok.RequiredArgsConstructor;
import org.example.security.domain.Account;
import org.example.security.domain.AccountLoginDto;
import org.example.security.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
  private final AccountService accountService;

  @GetMapping("/login")
  public String login() {
    return "basic/login";
  }

  @PostMapping("/login")
  public String login(AccountLoginDto account) {
    Boolean validUser = accountService.isValidUser(account);
    return validUser ? "redirect:/enter" : "redirect:/login";
  }
}

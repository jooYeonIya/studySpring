package org.example.security.controller;

import lombok.RequiredArgsConstructor;
import org.example.security.domain.Account;
import org.example.security.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccountController {
  private final AccountService accountService;

  @GetMapping("/account/new")
  public String newAccount() {
    return "account/new";
  }

  @PostMapping("/account/new")
  public String newAccount(Account account) {
    accountService.addAccount(account);
    return "redirect:/login";
  }
}

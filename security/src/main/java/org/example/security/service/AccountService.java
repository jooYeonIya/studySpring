package org.example.security.service;

import lombok.RequiredArgsConstructor;
import org.example.security.domain.Account;
import org.example.security.domain.AccountLoginDto;
import org.example.security.repository.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {
  private final AccountRepository accountRepository;
  private final PasswordEncoder encoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Account account = accountRepository.findByUsername(username);

    if (account == null) {
      throw new UsernameNotFoundException(username);
    }

    return User.builder()
        .username(account.getUsername())
        .password(encoder.encode(account.getPassword()))
        .roles(account.getRole())
        .build();
  }

  public void addAccount(Account account) {
    Account findAccount = accountRepository.findByUsername(account.getUsername());

    if (findAccount == null) {
      account.changePassword(account.getPassword(), encoder);
      account.setRole("USER");
      accountRepository.save(account);
    } else {
      throw new IllegalArgumentException("Account already exists");
    }
  }

  public Boolean isValidUser(AccountLoginDto account) {
    UserDetails userDetails = loadUserByUsername(account.getUsername());
    return userDetails != null && account.checkPassword(userDetails.getPassword());
  }
}

package org.example.security.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountLoginDto {
  private String username;
  private String password;

  public boolean checkPassword(String password) {
    return this.password.equals(password);
  }
}

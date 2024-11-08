package org.example.security.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Entity
@Getter
@Setter
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(unique=true)
  private String username;
  private String password;
  private String role;

  public void changePassword(String password, PasswordEncoder encoder) {
    this.password = encoder.encode(password);
  }
}

package org.example.minisns.user.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
public class UserSession {
  private String userName;
  private String userId;
}

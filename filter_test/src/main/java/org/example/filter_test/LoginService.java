package org.example.filter_test;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {
  public boolean isLoginSuccess(User user){
    return user != null && StringUtils.hasText(user.getUserId()) && StringUtils.hasText(user.getPassword());
  }
}

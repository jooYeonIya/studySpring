package org.example.filter_test;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/members")
public class LoginController {

  @GetMapping("/register")
  public String register(HttpServletRequest request) {
    log.info("register ==> {}", request.getRequestURI());
    return "회원 가입 완료";
  }

  @GetMapping("/login")
  public String login(HttpServletRequest request) {
    log.info("login ==> {}", request.getRequestURI());
    HttpSession session = request.getSession(true);
    session.setAttribute("userId", "admin");
    return session.getAttribute("userId") + "로그인 완료";
  }

  @GetMapping("/logout")
  public String logout(HttpServletRequest request) {
    log.info("logout ==> {}", request.getRequestURI());
    request.getSession(false).invalidate();
    return "로그인 완료";
  }
}

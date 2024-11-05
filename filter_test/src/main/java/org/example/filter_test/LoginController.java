package org.example.filter_test;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class LoginController {
  private final LoginService loginService;

  @GetMapping("/register")
  public String register(HttpServletRequest request) {
    log.info("register ==> {}", request.getRequestURI());
    return "회원 가입 완료";
  }

  @PostMapping("/login")
  public String login(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
    log.info("login ==> {}", request.getRequestURI());

    boolean isLogin = loginService.isLoginSuccess(user);
    UUID uuid = UUID.randomUUID();

    if (isLogin) {
      HttpSession session = request.getSession(true);
      session.setAttribute("userId", user.getUserId());
      session.setAttribute("uuid", uuid);
      session.setMaxInactiveInterval(60);
      Cookie cookie = new Cookie("userId", uuid.toString());
      response.addCookie(cookie);
      return "로그인 성공";
    }

    return "로그인 실패";
  }

  @GetMapping("/logout")
  public String logout(HttpServletRequest request, HttpServletResponse response) {
    log.info("logout ==> {}", request.getRequestURI());
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
      Cookie cookie = new Cookie("userId", null);
      cookie.setMaxAge(0);
      cookie.setPath("/");
      response.addCookie(cookie);
      return "로그아웃 성공";
    }
    return "로그아웃 실패";
  }
}

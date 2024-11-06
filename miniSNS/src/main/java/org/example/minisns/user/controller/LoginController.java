package org.example.minisns.user.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.minisns.user.domain.User;
import org.example.minisns.user.domain.UserLoginDto;
import org.example.minisns.user.service.LoginService;
import org.example.minisns.user.service.UserService;
import org.example.minisns.user.session.SessionConst;
import org.example.minisns.user.session.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {
  private final LoginService loinService;

  @GetMapping("/login")
  public String login() {
    return "login/login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute UserLoginDto userLoginDto,
                      @RequestParam(name="redirectURI", required = true, defaultValue = "/posts") String redirectURI,
                      HttpServletResponse response,
                      HttpServletRequest request) {
    User loginUser = loinService.login(userLoginDto);
    if (loginUser == null) {
      return "redirect:/login";
    } else {
      UserSession userSession = new UserSession(loginUser.getUserName(), loginUser.getUserId());
      HttpSession session = request.getSession(true);
      session.setAttribute(SessionConst.USER_SESSION, userSession);

      Cookie cookie = new Cookie(SessionConst.USER_COOKIE, SessionConst.USER_SESSION);
      cookie.setPath("/");
      cookie.setMaxAge(600); // 초단위
      response.addCookie(cookie);
      return "redirect:" + redirectURI;
    }
  }

  @GetMapping("/logout")
  public String logout(HttpServletResponse response, HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }

    Cookie cookie = new Cookie(SessionConst.USER_COOKIE, null);
    cookie.setMaxAge(0);
    response.addCookie(cookie);

    return "redirect:/login";
  }
}

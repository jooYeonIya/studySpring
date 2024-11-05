package org.example.filter_test;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter { // 로그인 여부를 체크하는 필터
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    // true 는 세션이 있으면 반환, 없으면 새 세션 생성
    // false 는 세션이 있으면 반환 , 없으면 null 반환
    HttpSession session = req.getSession(true);

    if (session == null) {
      log.info("로그인 아녀~");
    } else {
      log.info("로그인 했슈~");
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }
}

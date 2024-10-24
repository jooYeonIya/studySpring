package com.example.student.ch07;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebFilter("/news")
@Slf4j
public class EncodingFilter implements Filter {
  // 필터는 서블릿 앞에서 불리워져서, 로그인 등에서 많이 활용됨
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    // 다운 캐스팅 필요
    HttpServletRequest request = (HttpServletRequest) servletRequest;

    if (true) { // 로그인 하지 않은 상황이라고 가정해보자
      log.info("로그인 안 함");

    } else {
      request.setCharacterEncoding("UTF-8");
      log.info("getCharacterEncoding {}", request.getCharacterEncoding());
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }
}

package org.example.filter_test;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    // 사용자의 요청에 대해 로그 남기기 - 어떤 핸들러가 처리하고 있는지, 어떤 화면으로 들어온 요청인지
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    String requestURI = request.getRequestURI();
    log.info("request ==> {}", requestURI);
    filterChain.doFilter(servletRequest, servletResponse);
  }
}

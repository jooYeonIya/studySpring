package org.example.filter_test;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
  // 반드시 구현해야할 메소드는 없음

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    log.info("preHnadle ==> request {}", request.getRequestURI());

    Method method = ((HandlerMethod) handler).getMethod();
    log.info("preHnadle ==> handler {}", method.getDeclaringClass().getName()); // 어느 클래스에서 불려졌는지 알 수 있음
    log.info("preHnadle ==> handler {}", method.getName()); // 그 클래스의 어떤 메소드에서 불려졌는지 알 수 있음
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    log.info("postHandle ==> request {}", request.getRequestURI());
    Method method = ((HandlerMethod) handler).getMethod();
    log.info("postHandle ==> handler {}", method.getDeclaringClass().getName());
    log.info("postHandle ==> handler {}", method.getName());
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
  }
}

package org.example.filter_test;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class Logging {
  @Before("execution(* org.example.filter_test..*(..))") //뭐가 실행되기 전에 모든 매개변수의 모든 메소드
  public void leavingLog(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String className = joinPoint.getTarget().getClass().getName();
    log.info("{} : {} 가 실행되기 전  ", className, methodName);
  }
}

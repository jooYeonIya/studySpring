package org.example.minishopping.controller;

import org.example.minishopping.dto.ErrorResult;
import org.example.minishopping.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 이 한 클래스에서 예외처리를 모두 모아서 할 수 있음
@RestControllerAdvice(annotations = RestController.class)
public class ExControllerAdvice {
  @ResponseStatus(HttpStatus.BAD_REQUEST) // 이 설정까지 해주면  http 스테이터스 코드도 400으로 가게 된다
  @ExceptionHandler // 여기까지만 설정해주면 에러는 발생하지만 http 스테이터스 코드는 200으로 감
  public ErrorResult handleValidationException(ValidationException ex) {
    return new ErrorResult(HttpStatus.BAD_REQUEST, ex.getMessage());
  }
}

package org.example.minishopping.exception;

public class OrderCancelException extends RuntimeException {
  public OrderCancelException() {
    super();
  }

  public OrderCancelException(String message) {
    super(message);
  }
}


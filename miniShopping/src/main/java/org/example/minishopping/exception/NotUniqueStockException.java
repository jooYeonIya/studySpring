package org.example.minishopping.exception;

public class NotUniqueStockException extends RuntimeException {
  public NotUniqueStockException() {
    super();
  }

  public NotUniqueStockException(String message) {
    super(message);
  }
}


package org.example.minishopping.exception;

public class NoEnoughStockException extends RuntimeException{
  public NoEnoughStockException() {
     super();
  }

  public NoEnoughStockException(String message) {
    super(message);
  }
}

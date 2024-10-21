package com.example.jwbook.ch05;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
  private long id;
  private String name;
  private int price;
  private String date;
  private String maker;

  public Product(long id, String name, int price, String date, String maker) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.date = date;
    this.maker = maker;
  }
}

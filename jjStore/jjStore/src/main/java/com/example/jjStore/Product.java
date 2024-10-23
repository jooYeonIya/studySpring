package com.example.jjStore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
  private int id;
  private String name;
  private int price;
  private String maker;
  private int stock;

  public Product(int id, String name, int price, String maker, int stock) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.maker = maker;
    this.stock = stock;
  }

  public Product( String name, int price, String maker, int stock) {
    this.name = name;
    this.price = price;
    this.maker = maker;
    this.stock = stock;
  }
}

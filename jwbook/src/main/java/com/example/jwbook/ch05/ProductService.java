package com.example.jwbook.ch05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
  Map<Long, Product> productMap = new HashMap<>();

  private static long seq = 0L;

  public ProductService() {
    Product p = new Product(++seq, "갤럭시", 1000, "삼성", "2024-10-21");
    productMap.put(p.getId(), p);

    p = new Product(++seq, "아이폰", 2000, "애플", "2024-10-21");
    productMap.put(p.getId(), p);
  }

  public List<Product> findAllProduct() {
    return new ArrayList<>(productMap.values());
  }

  public Product findById(Long id) {
    return productMap.get(id);
  }
}

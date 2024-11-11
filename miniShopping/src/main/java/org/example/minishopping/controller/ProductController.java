package org.example.minishopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.minishopping.dto.ProductCreateDto;
import org.example.minishopping.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping/product")
public class ProductController {
  private final ProductService productService;

  @PostMapping("/add")
  public void add(ProductCreateDto dto) {
    productService.addProduct(dto);
  }
}

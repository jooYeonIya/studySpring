package org.example.minishopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.minishopping.dto.StockCreateDto;
import org.example.minishopping.service.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping/stock")
public class StockController {
  private final StockService stockService;

  @PostMapping("/add")
  public void add(StockCreateDto dto) {
    stockService.addStock(dto);
  }
}

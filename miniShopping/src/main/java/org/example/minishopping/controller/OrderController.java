package org.example.minishopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.minishopping.dto.OrderCreateDto;
import org.example.minishopping.dto.OrderProductCreateDto;
import org.example.minishopping.dto.OrderRequestDto;
import org.example.minishopping.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping/order")
public class OrderController {
  private final OrderService orderService;

  @PostMapping("/add")
  public void add(@RequestBody OrderRequestDto dto) {
    orderService.createOrder(dto.getOrderDto(), dto.getOrderProductDtos());
  }

  @PostMapping("/cancel/{orderProductId}")
  public void cancel(@PathVariable Long orderProductId) {
    orderService.cancelOrderProduct(orderProductId);
  }
}


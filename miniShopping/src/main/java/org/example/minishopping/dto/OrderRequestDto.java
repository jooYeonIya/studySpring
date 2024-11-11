package org.example.minishopping.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDto {
    private OrderCreateDto orderDto;
    private List<OrderProductCreateDto> orderProductDtos;
}

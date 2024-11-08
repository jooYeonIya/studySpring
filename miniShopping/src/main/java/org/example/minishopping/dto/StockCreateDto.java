package org.example.minishopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.minishopping.entity.status.Warehouse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockCreateDto {
  private Warehouse warehouse;
  private Long productId;
  private int quantity;
}

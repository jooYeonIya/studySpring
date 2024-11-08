package org.example.minishopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.minishopping.entity.Member;
import org.example.minishopping.entity.Product;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInquiryDto {
  private Long productId;
  private String productName;
  private int price;

  public static ProductInquiryDto of(Product product) {
    return new ProductInquiryDto(product.getProductId(), product.getProductName(), product.getPrice());
  }
}

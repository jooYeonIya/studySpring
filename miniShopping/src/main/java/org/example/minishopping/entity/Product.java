package org.example.minishopping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.minishopping.entity.status.ProductStatus;

import java.time.LocalDate;

// 상품
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int productId;
  @Column(length = 20)
  private String productName;
  private int cost;
  private int price;
  @Enumerated(EnumType.STRING)
  private ProductStatus status;
  private LocalDate registrationDate;
  private LocalDate changeStatusDate;

  // 가격 변경 불가

  // 편의 메서드
  public void changeStatus(ProductStatus newStatus) {
    this.status = newStatus;
    this.changeStatusDate = LocalDate.now();
  }

}

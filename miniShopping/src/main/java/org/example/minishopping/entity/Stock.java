package org.example.minishopping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.minishopping.entity.status.OrderProductStatus;
import org.example.minishopping.entity.status.OrderStatus;
import org.example.minishopping.entity.status.Warehouse;
import org.example.minishopping.exception.NoEnoughStockException;
import org.example.minishopping.exception.OrderCancelException;

// 재고
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Enumerated(EnumType.STRING)
  private Warehouse warehouse;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;
  private long quantity; // 수량

  // 편의 메소드 : 수량 증가(주문취소시) / 수량 감소 (주문완료시)
  public void increaseStock(long quantity) {
    this.quantity += quantity;
  }

  public void decreaseStock(long quantity) {
    if (this.quantity < quantity) {
      throw new NoEnoughStockException("재고 부족");
    } else {
      this.quantity -= quantity;
    }
  }
}

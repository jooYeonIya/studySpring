package org.example.minishopping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.minishopping.entity.status.OrderProductStatus;
import org.example.minishopping.entity.status.OrderStatus;
import org.example.minishopping.exception.OrderCancelException;

// 주문 상품
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productOrderId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;
  private int quantity;
  private int price;
  @Enumerated(EnumType.STRING)
  private OrderProductStatus status;

  public void setOrder(Order order) {
    this.order = order;
  }

  public static OrderProduct createOrderProduct(Product product, int quantity, int price, Stock stock) {
    OrderProduct orderProduct = new OrderProduct(null, null, product, quantity, price, OrderProductStatus.ORDERED);
    stock.decreaseStock(quantity);
    return orderProduct;
  }

  public void cancelOrderProduct(Stock stock) {
    if (order.getStatus() == OrderStatus.ORDERED || order.getStatus() == OrderStatus.PARTIALCANCELLED) {
      this.status = OrderProductStatus.CANCELLED;
      stock.increaseStock(quantity);
    } else {
      new OrderCancelException("주문 완료, 주문 취소 일 때만 취소 가능");
    }
  }

  // 취소: status 변경 / order 의 status 가 ordered, PARTIALCANCELLED 상태일 때만 가능
  // 재고가 + 되어야 하고 order의 status와 statusdate가 변경되어야 하고
  //  order의 totalquantity와 totalpricd가 변경되어야 함

}

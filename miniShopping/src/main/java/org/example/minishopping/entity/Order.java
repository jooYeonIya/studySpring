package org.example.minishopping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.minishopping.entity.status.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// 주문
@Entity
@Table(name = "orders")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;
  private LocalDateTime orderDate;
  // 총 주문 수량
  private long totalQuantity;
  // 총 주문 액
  private long totalPrice;
  @Enumerated(EnumType.STRING)
  private OrderStatus status;
  private LocalDateTime statusDate;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // CascadeType.ALL은 모든 상태 변화가 전달되도록 설정
  @JoinColumn(name = "delivery_id") // 양방향 관계, 연관 관계의 주인
  private Delivery delivery;
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderProduct> orderProducts;

  // 주문 생성
  public static Order createOrder(Member member, Delivery delivery, List<OrderProduct> orderProducts) {
    Order order = new Order(null,
        member,
        LocalDateTime.now(),
        0,
        0,
        OrderStatus.ORDERED,
        LocalDateTime.now(),
        delivery,
        new ArrayList<OrderProduct>());

    for (OrderProduct orderProduct : orderProducts) {
      order.totalQuantity += orderProduct.getQuantity();
      order.totalPrice += (long) orderProduct.getPrice() * orderProduct.getQuantity();
      orderProduct.setOrder(order);
      order.orderProducts.add(orderProduct);
      delivery.setOrder(order);
    }

    return order;
  }

  public void partialOrderCancel(OrderProduct orderProduct) {
    if (this.status == OrderStatus.ORDERED | this.status == OrderStatus.PARTIALCANCELLED) {
      this.status = OrderStatus.PARTIALCANCELLED;
      this.statusDate = LocalDateTime.now();
      this.totalQuantity -= orderProduct.getQuantity(); ;
      this.totalPrice -= orderProduct.getPrice() * orderProduct.getQuantity();
    }
  }

  public void totalOrderCancel() {
    if (this.status == OrderStatus.ORDERED | this.status == OrderStatus.PARTIALCANCELLED) {
      this.status = OrderStatus.TOTALCANCELLED;
      this.statusDate = LocalDateTime.now();
      this.totalQuantity = 0;
      this.totalPrice = 0;
      // 딜리버리의 상태도 업데이트 해줘야 할 듯
    }
  }
}

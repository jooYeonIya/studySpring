package org.example.minishopping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.minishopping.entity.status.DeliveryStatus;

import java.time.LocalDateTime;

// 배송
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long deliveryId;
  @OneToOne(fetch = FetchType.LAZY, mappedBy = "delivery") // 양방향 관계
  private Order order;
  @Column(length = 100)
  private String address;
  private DeliveryStatus status;
  private LocalDateTime deliveryTime;

  public void setAddress(String address) {
    this.address = address;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public void changeStatus(DeliveryStatus status) {
    this.status = status;
    this.deliveryTime = LocalDateTime.now();
  }
}

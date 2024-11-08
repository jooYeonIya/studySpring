package org.example.minishopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.minishopping.entity.Order;
import org.example.minishopping.entity.Product;
import org.example.minishopping.entity.status.OrderStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderInquiryDto {
  private Long orderId;
  private int memberId;
  private String memberName;
  private LocalDateTime orderDate;
  private long totalQuantity;
  private long totalPrice;
  private OrderStatus status;
  private LocalDateTime stateChangeDate;

  public static OrderInquiryDto of(Order order) {
    OrderInquiryDto dto = new OrderInquiryDto();
    dto.setOrderId(order.getOrderId());
    dto.setMemberId(order.getMember().getMemberId());
    dto.setMemberName(order.getMember().getMemberName());
    dto.setOrderDate(order.getOrderDate());
    dto.setTotalQuantity(order.getTotalQuantity());
    dto.setTotalPrice(order.getTotalPrice());
    dto.setStatus(order.getStatus());
    dto.setStateChangeDate(order.getStatusDate());
    return dto;
  }
}

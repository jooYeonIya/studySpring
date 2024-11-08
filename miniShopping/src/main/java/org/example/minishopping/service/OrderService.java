package org.example.minishopping.service;

import lombok.RequiredArgsConstructor;
import org.example.minishopping.dto.OrderCreateDto;
import org.example.minishopping.dto.OrderInquiryDto;
import org.example.minishopping.dto.OrderProductCreateDto;
import org.example.minishopping.entity.*;
import org.example.minishopping.entity.status.DeliveryStatus;
import org.example.minishopping.entity.status.OrderProductStatus;
import org.example.minishopping.entity.status.Warehouse;
import org.example.minishopping.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
  private final MemberRepository memberRepository;
  private final ProductRepository productRepository;
  private final StockRepository stockRepository;
  private final OrderRepository orderRepository;
  private final OrderProductRepository orderProductRepository;
  private final DeliveryRepository deliveryRepository;

  public OrderInquiryDto createOrder(OrderCreateDto orderDto, OrderProductCreateDto... orderProductDtos) {
    Member member = memberRepository.findById(orderDto.getMemberId()).get();

    List<OrderProduct> orderProducts = new ArrayList<>();
    for (OrderProductCreateDto dto : orderProductDtos) {
      Product product = productRepository.findById(dto.getProductId()).get();
      Stock stock = stockRepository.findByWarehouseAndProduct(Warehouse.KR, product).get();
      OrderProduct orderProduct = OrderProduct.createOrderProduct(product, dto.getQuantity(), product.getPrice(), stock);
      orderProducts.add(orderProduct);
    }

    Delivery delivery = new Delivery(0, null, orderDto.getAddress(), DeliveryStatus.PREPARED, LocalDateTime.now());

    Order order = Order.createOrder(member, delivery, orderProducts);
    delivery.setOrder(order);
    orderRepository.save(order);
    return OrderInquiryDto.of(order);
  }
}

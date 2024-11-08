package org.example.minishopping.service;

import org.assertj.core.api.Assertions;
import org.example.minishopping.dto.*;
import org.example.minishopping.entity.Member;
import org.example.minishopping.entity.Order;
import org.example.minishopping.entity.Product;
import org.example.minishopping.entity.status.Warehouse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit //DB에 잘 들어가는지 확인 가능
class OrderServiceTest {
  @Autowired
  private OrderService orderService;

  @Autowired
  private MemberService memberService;

  @Autowired
  private ProductService productService;

  @Autowired
  private StockService stockService;

  @Test
  public void 주문생성테스트() {
    MemberCreateDto memberCreateDto = new MemberCreateDto(
        "test",
        "testid",
        "1111",
        "e@mail.com",
        "0100000000",
        "ori");
    Member member = memberService.addMember(memberCreateDto);

    ProductCreateDto productCreateDto = new ProductCreateDto("test1", 100, 120);
    ProductInquiryDto productInquiryDto = productService.addProduct(productCreateDto);

    StockCreateDto stockDto = new StockCreateDto(Warehouse.KR, productInquiryDto.getProductId(), 10000);
    stockService.addStock(stockDto);

    OrderCreateDto orderCreateDto = new OrderCreateDto(member.getMemberId(), "testAdd");
    OrderProductCreateDto orderProductCreateDto = new OrderProductCreateDto(productInquiryDto.getProductId(), 100);
    orderService.createOrder(orderCreateDto, orderProductCreateDto);
  }
}
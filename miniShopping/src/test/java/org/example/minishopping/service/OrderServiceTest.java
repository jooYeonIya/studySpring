package org.example.minishopping.service;

import org.assertj.core.api.Assertions;
import org.example.minishopping.dto.*;
import org.example.minishopping.entity.*;
import org.example.minishopping.entity.status.OrderStatus;
import org.example.minishopping.entity.status.Warehouse;
import org.example.minishopping.repository.OrderRepository;
import org.example.minishopping.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

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
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private StockRepository stockRepository;

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

  @Test
  public void 주문취소테스트() {
    Order order = null;
    OrderProduct orderProduct = null;
    Stock stock = null;
    MemberInquiryDto testid = memberService.getOneMember("testid");
    OrderInquiryDto oneOrderByMember = orderService.getOneOrderByMember(testid.getUserId());
    if (oneOrderByMember != null) {
      order = orderRepository.findById(oneOrderByMember.getOrderId()).get();
      orderProduct = order.getOrderProducts().get(0);
      orderService.cancelOrderProduct(orderProduct.getProductOrderId());
      stock = stockRepository.findByWarehouseAndProduct(Warehouse.KR, orderProduct.getProduct()).get();
    }
    Assertions.assertThat(order).isNotNull();
    Assertions.assertThat(order.getStatus()).isEqualTo(OrderStatus.TOTALCANCELLED);
    Assertions.assertThat(orderProduct).isNotNull();
    Assertions.assertThat(stock.getQuantity()).isEqualTo(10000l);
  }
}
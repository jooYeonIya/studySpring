package org.example.minishopping.service;

import org.assertj.core.api.Assertions;
import org.example.minishopping.dto.ProductCreateDto;
import org.example.minishopping.dto.ProductInquiryDto;
import org.example.minishopping.dto.StockCreateDto;
import org.example.minishopping.entity.Product;
import org.example.minishopping.entity.Stock;
import org.example.minishopping.entity.status.Warehouse;
import org.example.minishopping.exception.NotUniqueProductNameException;
import org.example.minishopping.exception.NotUniqueStockException;
import org.example.minishopping.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StockServiceTest {

  @Autowired
  private StockService stockService;

  @Autowired
  private ProductService productService;

  @Autowired
  private StockRepository stockRepository;

  @Test
  public void 상품재고등록테스트() {
    ProductCreateDto productCreateDto = new ProductCreateDto("test1", 100, 120);
    ProductInquiryDto productInquiryDto = productService.addProduct(productCreateDto);
    StockCreateDto stockDto = new StockCreateDto(Warehouse.KR, productInquiryDto.getProductId(), 10);
    StockCreateDto stockDto2 = new StockCreateDto(Warehouse.KR, productInquiryDto.getProductId(), 10);
    stockService.addStock(stockDto);
    Assertions.assertThat(stockRepository.findAll().size()).isEqualTo(1);
    assertThrows(NotUniqueStockException.class, () -> stockService.addStock(stockDto2));
  }
}
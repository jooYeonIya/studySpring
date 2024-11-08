package org.example.minishopping.service;

import org.assertj.core.api.Assertions;
import org.example.minishopping.dto.ProductCreateDto;
import org.example.minishopping.entity.Product;
import org.example.minishopping.entity.status.ProductStatus;
import org.example.minishopping.exception.NotUniqueProductNameException;
import org.example.minishopping.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductServiceTest {
  @Autowired
  private ProductService productService;

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void 제품등록테스트() {
    // given
    ProductCreateDto productCreateDto1 = new ProductCreateDto("test1", 100, 120);
    ProductCreateDto productCreateDto2 = new ProductCreateDto("test1", 100, 120);

    // when // then 1
    productService.addProduct(productCreateDto1);
    Assertions.assertThat(productRepository.findAll().size()).isEqualTo(1);

    // when // then 2 - 예외 처리
    assertThrows(NotUniqueProductNameException.class, () -> productService.addProduct(productCreateDto2));
  }
}
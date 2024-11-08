package org.example.minishopping.service;

import lombok.RequiredArgsConstructor;
import org.example.minishopping.dto.ProductCreateDto;
import org.example.minishopping.dto.ProductInquiryDto;
import org.example.minishopping.entity.Member;
import org.example.minishopping.entity.Product;
import org.example.minishopping.entity.status.ProductStatus;
import org.example.minishopping.exception.NotUniqueProductNameException;
import org.example.minishopping.exception.NotUniqueUserIdException;
import org.example.minishopping.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
  public final ProductRepository productRepository;

  // 상품 정보 저장
  public ProductInquiryDto addProduct(ProductCreateDto dto) {
    if (checkUniqueProductName(dto.getProductName())) {
      Product product = new Product(0l,
          dto.getProductName(),
          dto.getPrice(),
          dto.getCost(),
          ProductStatus.ACTIVE,
          LocalDate.now(),
          null);
      Product saveProduct = productRepository.save(product);
      return ProductInquiryDto.of(saveProduct);
    }

    return null;
  }

  public boolean checkUniqueProductName(String productName) {
    Optional<Product> optionalProduct = productRepository.findByProductName(productName);
    if (optionalProduct.isPresent()) {
      throw new NotUniqueProductNameException("이미 존재하는 제품명입니다");
    }
    return true;
  }
}

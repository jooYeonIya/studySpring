package org.example.minishopping.service;

import lombok.RequiredArgsConstructor;
import org.example.minishopping.dto.StockCreateDto;
import org.example.minishopping.entity.Product;
import org.example.minishopping.entity.Stock;
import org.example.minishopping.entity.status.Warehouse;
import org.example.minishopping.exception.NotUniqueStockException;
import org.example.minishopping.repository.ProductRepository;
import org.example.minishopping.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StockService {
  private final StockRepository stockRepository;
  private final ProductRepository productRepository;

  public int addStock(StockCreateDto dto) {
    Product product = productRepository.findById(dto.getProductId()).get();
    if (checkUniqueStock(Warehouse.KR, product)) {
      Stock stock = new Stock(0, Warehouse.KR, product, dto.getQuantity());
      return stockRepository.save(stock).getId();
    }
    return 0;
  }

  public boolean checkUniqueStock(Warehouse warehouse, Product product) {
    Optional<Stock> optionalStock = stockRepository.findByWarehouseAndProduct(warehouse, product);
    if (optionalStock.isPresent()) {
      throw new NotUniqueStockException("이미 재고 자료가 존재합니다.");
    }
    return true;
  }
}

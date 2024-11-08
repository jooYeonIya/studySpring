package org.example.minishopping.repository;

import org.example.minishopping.entity.Product;
import org.example.minishopping.entity.Stock;
import org.example.minishopping.entity.status.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Integer> {
  Optional<Stock> findByWarehouseAndProduct(Warehouse warehouse, Product product);
}

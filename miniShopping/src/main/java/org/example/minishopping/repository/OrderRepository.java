package org.example.minishopping.repository;

import org.example.minishopping.entity.Member;
import org.example.minishopping.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
  Optional<Order> findByMember(Member member);
}

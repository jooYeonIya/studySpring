package org.example.minishopping.repository;

import org.example.minishopping.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
  public Optional<Member> findByUserId(String userId);
}

package org.example.minisns.repository;

import org.example.minisns.domain.SNS;
import org.springframework.data.jpa.repository.JpaRepository;

// <엔티티, PK>
public interface SNSRepository extends JpaRepository<SNS, Integer> {
}

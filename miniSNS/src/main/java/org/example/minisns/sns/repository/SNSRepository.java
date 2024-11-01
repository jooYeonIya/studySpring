package org.example.minisns.sns.repository;

import org.example.minisns.sns.domain.SNS;
import org.springframework.data.jpa.repository.JpaRepository;

// <엔티티, PK>
public interface SNSRepository extends JpaRepository<SNS, Integer> {
}

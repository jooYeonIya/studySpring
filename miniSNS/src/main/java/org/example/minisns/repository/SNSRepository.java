package org.example.minisns.repository;

import org.example.minisns.domain.SNS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SNSRepository extends JpaRepository<SNS, String> {
}

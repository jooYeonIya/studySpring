package org.example.minisns.sns.repository;

import org.example.minisns.sns.domain.SNS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// <엔티티, PK>
public interface SNSRepository extends JpaRepository<SNS, Integer>, SNSRepositoryCustom {

  @Query("select s from SNS s left join fetch s.user where s.id = :id")
  SNS findBySNSWithUserFetchjoin(int id);
}

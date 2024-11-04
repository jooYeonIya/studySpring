package org.example.minisns.sns.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.example.minisns.sns.domain.QSNS;
import org.example.minisns.sns.domain.QSNSDetailResponseDto;
import org.example.minisns.sns.domain.SNSDetailResponseDto;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class SNSRepositoryCustomImpl implements SNSRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  @Autowired
  public SNSRepositoryCustomImpl(EntityManager entityManager) {
    this.queryFactory = new JPAQueryFactory(entityManager);
  }

  @Override
  public List<SNSDetailResponseDto> getByUserId(String userId) {
    QSNS sns = QSNS.sNS;
    return queryFactory.select(new QSNSDetailResponseDto(
            sns.id,
            sns.title,
            sns.body,
            sns.likes,
            sns.user.userId
        )).from(sns)
        .fetch();
  }
}

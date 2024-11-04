package org.example.minisns.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.minisns.user.domain.QUser;
import org.example.minisns.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
  private final JPAQueryFactory queryFactory;

  @Autowired
  public UserRepositoryCustomImpl(EntityManager entityManager) {
    this.queryFactory = new JPAQueryFactory(entityManager);
  }

  @Override
  public List<User> findByUserIdAndUserName(String userId, String userName) {
    QUser user = QUser.user;
    return queryFactory.selectFrom(user)
        .where(user.userId.eq(userId), user.userName.eq(userName))
        .fetch();
  }
}

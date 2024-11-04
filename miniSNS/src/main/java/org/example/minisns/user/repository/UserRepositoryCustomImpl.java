package org.example.minisns.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.minisns.user.domain.QUser;
import org.example.minisns.user.domain.User;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
  private final JPAQueryFactory queryFactory;

  @Override
  public List<User> findByUserIdAndUserName(String userId, String userName) {
    QUser user = QUser.user;
    return queryFactory.selectFrom(user)
        .where(user.userId.eq(userId), user.userName.eq(userName))
        .fetch();
  }
}

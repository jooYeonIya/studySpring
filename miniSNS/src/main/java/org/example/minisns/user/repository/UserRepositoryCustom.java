package org.example.minisns.user.repository;

import org.example.minisns.user.domain.User;

import java.util.List;

public interface UserRepositoryCustom {
  List<User> findByUserIdAndUserName(String userId, String userName);
}

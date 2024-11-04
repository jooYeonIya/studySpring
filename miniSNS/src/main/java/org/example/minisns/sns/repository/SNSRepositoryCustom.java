package org.example.minisns.sns.repository;

import org.example.minisns.sns.domain.SNSDetailResponseDto;

import java.util.List;

public interface SNSRepositoryCustom {
  List<SNSDetailResponseDto> getByUserId(String userId);
}

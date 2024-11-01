package org.example.minisns.sns.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SNSAllResponseDto {
  private int id;
  private String title;
  private String body;
  private String userId;

  public static SNSAllResponseDto of(SNS sns) {
    return new SNSAllResponseDto(sns.getId(), sns.getTitle(), sns.getBody(), sns.getUser().getUserId());
  }
}

package org.example.minisns.sns.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SNSCreateRequestDto {
  private String title;
  private String body;
  private String userId;
}

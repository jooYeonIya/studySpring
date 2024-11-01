package org.example.minisns.sns.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SNSDetailResponseDto {
  private int id;
  private String title;
  private String body;
  private int likes;
  private String userId;
}

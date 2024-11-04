package org.example.minisns.sns.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SNSDetailResponseDto {
  private int id;
  private String title;
  private String body;
  private int likes;
  private String userId;

  @QueryProjection
  public SNSDetailResponseDto(int id, String title, String body, int likes, String userId) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.likes = likes;
    this.userId = userId;
  }
}

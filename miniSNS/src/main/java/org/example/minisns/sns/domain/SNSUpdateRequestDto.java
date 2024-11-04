package org.example.minisns.sns.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SNSUpdateRequestDto {
  private String title;
  private String body;
}

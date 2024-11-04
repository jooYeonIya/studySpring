package org.example.minisns.sns.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SNSCreateRequestDto {
  private String title;
  private String body;
}

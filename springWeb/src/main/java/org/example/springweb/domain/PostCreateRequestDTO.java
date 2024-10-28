package org.example.springweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostCreateRequestDTO {
  private String title;
  private String content;

}

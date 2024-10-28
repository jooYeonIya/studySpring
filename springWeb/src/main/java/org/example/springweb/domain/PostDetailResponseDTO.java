package org.example.springweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDetailResponseDTO {
  private int id;
  private String title;
  private String content;
  private int likes;
}

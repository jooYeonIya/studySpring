package org.example.springweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostAllResponseDTO {
  private int id;
  private String title;
  private String content;

  public static PostAllResponseDTO of(Post post) {
    return new PostAllResponseDTO(post.getId(), post.getTitle(), post.getContent());
  }
}

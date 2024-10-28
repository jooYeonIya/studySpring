package org.example.springweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Post {
  private int id;
  private String title;
  private String content;
  private int likes;
}

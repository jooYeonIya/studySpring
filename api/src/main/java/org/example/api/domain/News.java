package org.example.api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class News {
  private int aid;
  private String title;
  private String content;
  private String img;
  private String date;
}

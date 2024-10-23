package com.example.student.ch07;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class News {
  private int aid;
  private String title;
  private String img;
  private String content;
  private String date;

  public News(int aid, String title, String img, String content, String date) {
    this.aid = aid;
    this.title = title;
    this.img = img;
    this.content = content;
    this.date = date;
  }
}

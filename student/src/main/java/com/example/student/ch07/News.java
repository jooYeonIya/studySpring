package com.example.student.ch07;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// getter, setter, toString 등 다 들어가는 어노테이션!
@Data
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

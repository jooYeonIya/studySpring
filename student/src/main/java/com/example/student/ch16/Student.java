package com.example.student.ch16;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Student {
  private int id;
  private String name;
  private String univ;
  private String email;
  private Date birth;

  public Student(int id, String name, String univ, String email, Date birth) {
    this.id = id;
    this.name = name;
    this.univ = univ;
    this.email = email;
    this.birth = birth;
  }

  public Student(String name, String univ, String email, Date birth) {
    this.name = name;
    this.univ = univ;
    this.email = email;
    this.birth = birth;
  }
}

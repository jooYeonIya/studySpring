package org.example.spring_sample.student.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
  private int id;
  private String name;
  private String univ;
  private String birth;
  private String email;

}

package org.example.minisns.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="sns")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SNS {
  @Id
  private int id;
  @Column(length=6)
  private String title;
  @Column(length=45)
  private String body;
  private int likes;
}

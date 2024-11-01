package org.example.minisns.sns.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.minisns.user.domain.User;

//해당 클래스가 JPA(Entity)를 나타낸다는 것을 의미
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
  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
}


//Hibernate:
//create table sns (
//    id varchar(6) not null,
//body varchar(45),
//likes integer not null,
//title varchar(6),
//primary key (id)
//    ) engine=InnoDB
// 빌드 시, sns 테이블이 있는지 확인 후 없으면 만든다

//    Hibernate:
//    alter table sns
//    modify column id integer not null
// PK 데이터 타입을 int로 변경
// sns 테이블이 있어도 설정을 update로 했기 때문에 수정 사항이 있으면 업데이트도 해준다

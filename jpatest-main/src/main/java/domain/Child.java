package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Child { // Delivery 라고 생각해보자
  @Id
  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

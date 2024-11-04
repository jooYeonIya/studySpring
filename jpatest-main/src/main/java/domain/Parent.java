package domain;

import javax.persistence.*;

@Entity
public class Parent { // Order라고 생각해보자
  @Id
  private int pId;
  private String name;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
  @JoinColumn(name = "childId")
  private Child child;

  public int getpId() {
    return pId;
  }

  public void setpId(int pId) {
    this.pId = pId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Child getChild() {
    return child;
  }

  public void setChild(Child child) {
    this.child = child;
  }
}

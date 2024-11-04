package jpajava;

import domain.Child;
import domain.Department;
import domain.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CascadeTest {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    try {
      System.out.println("비영속 상태");

      Parent p = new Parent();
      p.setpId(1);
      p.setName("order");

      Child c = new Child();
      c.setId(1);
      c.setName("delivery");
      p.setChild(c);

      // 부모 객체만 영속 상태로 만들얻 부모에서 자식으로 전이가 되서 자식도 영속 상태가 된다
      em.persist(p);

      System.out.println("영속 상태");

      System.out.println("commit 전");
      tx.commit();
      System.out.println("commit 후");

    } catch (Exception e) {
      tx.rollback();
    }
  }
}


/*
비영속 상태
영속 상태
commit 전
-> insert문이 부모와 자식 두개 실행됨
Hibernate:
    insert
    into
        child
        (name, id)
    values
        (?, ?)
Hibernate:
    insert
    into
        parent
        (child_id, name, p_id)
    values
        (?, ?, ?)
commit 후
 */
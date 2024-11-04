package jpajava;

import domain.Child;
import domain.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CascadeTest2 {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    try {
      System.out.println("비영속 상태");

      Parent p = em.find(Parent.class, 1);
      Child c = p.getChild();
      c.setName("배송으로 업데이트");
      p.setName("주문으로 업데이트");
      p.setChild(c); // <- 영속성 전이되겠지 하고 생각하지 말고 설정을 해줘야 함!
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
Hibernate:
    select
        parent0_.p_id as p_id1_4_0_,
        parent0_.child_id as child_id3_4_0_,
        parent0_.name as name2_4_0_
    from
        parent parent0_
    where
        parent0_.p_id=?
Hibernate:
    select
        child0_.id as id1_0_0_,
        child0_.name as name2_0_0_
    from
        child child0_
    where
        child0_.id=?
영속 상태
commit 전

-> 업데이트 2번 실행됨

Hibernate:
    update
        parent
    set
        child_id=?,
        name=?
    where
        p_id=?
Hibernate:
    update
        child
    set
        name=?
    where
        id=?
commit 후

 */
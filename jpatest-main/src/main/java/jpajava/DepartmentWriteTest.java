package jpajava;

import domain.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DepartmentWriteTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            System.out.println("비영속 상태");
            Department dept1 = new Department();
            dept1.setDeptName("AA");
            Department dept2 = new Department();
            dept2.setDeptName("BB");
            Department dept3 = new Department();
            dept3.setDeptName("CC");
            em.persist(dept1);
            System.out.println("dept1 생성");
            em.persist(dept2);
            System.out.println("dept2 생성");
            em.persist(dept3);
            System.out.println("dept3 생성");
            System.out.println("commit 전");
            tx.commit();
            System.out.println("commit 후");
        } catch (Exception e) {
            tx.rollback();
        }

    }
}

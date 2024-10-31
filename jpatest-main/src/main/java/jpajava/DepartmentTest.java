package jpajava;

import domain.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DepartmentTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            System.out.println("비영속 상태");
            Department dept = new Department();
            dept.setDeptName("HR");
            em.persist(dept);
            System.out.println("영속 상태");
            Department dept2 = em.find(Department.class, dept.getDeptId());
            System.out.println(dept2.getDeptId()+ ":" + dept2.getDeptName() );
            System.out.println("1차 캐시에서 가져옴");
            System.out.println("commit 전");
            tx.commit();
            System.out.println("commit 후");
        } catch (Exception e) {
            tx.rollback();
        }

    }
}

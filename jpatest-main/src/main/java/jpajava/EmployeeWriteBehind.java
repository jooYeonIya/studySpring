package jpajava;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeWriteBehind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        System.out.println("트랜잭션 시작");
        try {
            Employee emp1 = new Employee("202403", "김연아3", null, "2024-01-01", 100L);
            Employee emp2 = new Employee("202404", "김연아4", null, "2024-01-01", 100L);
            Employee emp3 = new Employee("202405", "김연아5", null, "2024-01-01", 100L);
            em.persist(emp1);
            em.persist(emp2);
            em.persist(emp3);
            System.out.println("커밋 전");
            tx.commit();
            System.out.println("커밋 후");
        } catch (Exception e) {
            tx.rollback();
        }
    }
}

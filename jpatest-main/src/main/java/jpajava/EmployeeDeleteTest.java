package jpajava;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDeleteTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        System.out.println("트랜잭션 시작");
        try {
            System.out.println("비영속 상태");
            System.out.println("DB에서 가져옴");
            Employee emp = em.find(Employee.class, "202402");
            System.out.println(emp.getEmpName());
            System.out.println("1차 캐시에서 삭제함");
            em.remove(emp);
            System.out.println("커밋 전");
            tx.commit();
            System.out.println("커밋 후");
        } catch (Exception e) {
            tx.rollback();
        }
        System.out.println("트랜잭션 종료");
    }
}

package jpajava;

import domain.Department;
import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Emp_Dept_Update_Test {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    System.out.println("트랜잭션 시작");
    try {
      Department dept = new Department();
      dept.setDeptName("IT");
      em.persist(dept);

      System.out.println("부서 생성");

      // 202402인 데이터를 Employee형태로 찾아오기
      Employee employee = em.find(Employee.class, "202402");

      System.out.println("emp db에서 가져오기");

      employee.setDept(dept); // 객체로 설정하지만 db에는 1에서 2로 업데이트 될 것!

      // 더티 체킹을 통해서 데이터가 바뀐 것을 알고 업데이트함
      em.persist(employee);

      System.out.println("커밋 전");
      tx.commit();
      System.out.println("커밋 후");
    } catch (Exception e) {
      tx.rollback();
    }

    System.out.println("트랜잭션 종료");
  }
}

/*
      Employee employee = em.find(Employee.class, "202402"); 실행했을 때의 쿼리문
    select
        employee0_.emp_id as emp_id1_1_0_,
        employee0_.dept_id as dept_id5_1_0_,
        employee0_.emp_name as emp_name2_1_0_,
        employee0_.join_date as join_dat3_1_0_,
        employee0_.salary as salary4_1_0_,
        department1_.dept_id as dept_id1_0_1_,
        department1_.dept_name as dept_nam2_0_1_
    from
        employee employee0_
    left outer join
        dept department1_
            on employee0_.dept_id=department1_.dept_id
    where
        employee0_.emp_id=?
 */
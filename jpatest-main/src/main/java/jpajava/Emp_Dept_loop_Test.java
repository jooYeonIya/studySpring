package jpajava;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Emp_Dept_loop_Test {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    System.out.println("트랜잭션 시작");
    try {

      Employee employee = em.find(Employee.class, "202401");
      System.out.println("emp name : " + employee.getEmpName());
      System.out.println("dept name : " + employee.getDept().getDeptName());
      System.out.println(employee);


      tx.commit();
      System.out.println("커밋 후");
    } catch (Exception e) {
      tx.rollback();
    }
    System.out.println("트랜잭션 종료");
  }
}

// 쿼리 문이 따로따로 지연 로딩
// 지연 로딩할 때 프록시 객체를 내부적으로 사용함
/*
즉, dept_id 정보는 일단 프록시 객체를 사용해서 넣어둑
    select
        employee0_.emp_id as emp_id1_1_0_,
        employee0_.dept_id as dept_id5_1_0_,
        employee0_.emp_name as emp_name2_1_0_,
        employee0_.join_date as join_dat3_1_0_,
        employee0_.salary as salary4_1_0_
    from
        employee employee0_
    where
        employee0_.emp_id=?
emp name : 홍길동

실제로 dept_id 정보를 써야할 때 select 쿼리를 날려서 정보를 가져온다는 ㄳ
    select
        department0_.dept_id as dept_id1_0_0_,
        department0_.dept_name as dept_nam2_0_0_
    from
        dept department0_
    where
        department0_.dept_id=?
dept name : HR
 */

//같이 조인해서 가져오는 거 즉시 로딩
/*
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
emp name : 홍길동
dept name : HR
 */
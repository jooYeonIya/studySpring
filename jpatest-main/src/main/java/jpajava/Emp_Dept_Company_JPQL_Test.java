package jpajava;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Emp_Dept_Company_JPQL_Test {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    System.out.println("트랜잭션 시작");
    try {

      // Employee emp = em.find(Employee.class, "202402"); -> 이 부분을 JPQL 을 써서 찾아오기
      String jpql = "select e from Employee e join fetch e.dept";
      // createQuery(쿼리문, 반환 타입)
      List<Employee> emp = em.createQuery(jpql, Employee.class).getResultList();
      for (Employee employee : emp) {
        System.out.println(employee.getEmpName());
        // 지연 로딩 상태로 아래를 실행시키면
        // 처음 spql 로 한 번 가져오고
        // 각각 필요할 때맏 부서 이름을 불러오는 쿼리를 실행시킨다
        System.out.println(("부서 이름 :: " + employee.getDept().getDeptName()));
        // 그런데 join fetch 를 써서 쿼리문을 실행시키면 조인한 상태로 쿼리를 실행 = 1번만 실행
      }
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
트랜잭션 시작
Hibernate:
    select
        employee0_.emp_id as emp_id1_2_,
        employee0_.dept_id as dept_id5_2_,
        employee0_.emp_name as emp_name2_2_,
        employee0_.join_date as join_dat3_2_,
        employee0_.salary as salary4_2_
    from
        employee employee0_
Hibernate:
    select
        department0_.dept_id as dept_id1_1_0_,
        department0_.id as id3_1_0_,
        department0_.dept_name as dept_nam2_1_0_,
        company1_.id as id1_0_1_,
        company1_.name as name2_0_1_
    from
        dept department0_
    left outer join
        company company1_
            on department0_.id=company1_.id
    where
        department0_.dept_id=?
Hibernate:
    select
        department0_.dept_id as dept_id1_1_0_,
        department0_.id as id3_1_0_,
        department0_.dept_name as dept_nam2_1_0_,
        company1_.id as id1_0_1_,
        company1_.name as name2_0_1_
    from
        dept department0_
    left outer join
        company company1_
            on department0_.id=company1_.id
    where
        department0_.dept_id=?

DB에 2명이 존재함
JPQL로 날린 쿼리 문 1개와
연관된 테이블을 다 불러와야 하기 때문에 2번 더 쿼리문이 실행됨
(왜냐면 dept가 2개 존재했음)
 */

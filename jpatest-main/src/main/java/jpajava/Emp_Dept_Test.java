package jpajava;

import domain.Department;
import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Emp_Dept_Test {
  public static void main(String[] args) {
    // persistence.xml에 설정한 유닛 이름 입력
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    System.out.println("트랜잭션 시작");
    try {
      // 즉시 쓰기 처리되어, 영속성 컨텍스트에 등록되자마자 DB에 반영
      // 왜? Employee 객체에서 Department의 ID를 사용하기 때문에 먼저 만들어져 있어야 함
      Department dept = new Department(); // 비영속 상태
      dept.setDeptName("HR");
      em.persist(dept); // 영속성 켄텍스트에 추가, 엔티티는 비영속 상태에서 영속 상태로 변경

      System.out.println("부서 생성");

      // 트랜잭션이 커밋되기 전까지 지연 쓰기됩니다. 즉, 트랜잭션이 커밋되는 시점에 Employee 데이터가 데이터베이스에 반영
      Employee emp = new Employee();
      emp.setEmpId("202401");
      emp.setEmpName("홍길동");
      emp.setDept(dept); // 객체로 넣었지만 db에는 1로 입력될 것!
      emp.setJoinDate("2020-01-01");
      emp.setSalary(100);
      em.persist(emp);

      emp = new Employee();
      emp.setEmpId("202402");
      emp.setEmpName("김연아");
      emp.setDept(dept);
      emp.setJoinDate("2024-01-01");
      emp.setSalary(200);
      em.persist(emp);

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
부서 테이블이 먼저 만들어지고
create table dept (
       dept_id integer not null auto_increment,
        dept_name varchar(10) not null,
        primary key (dept_id)
    ) engine=InnoDB

사원 테이블이 만들어진 후에
    create table employee (
       emp_id varchar(6) not null,
        empName varchar(255),
        joinDate varchar(255),
        salary bigint not null,
        dept_id integer,
        primary key (emp_id)
    ) engine=InnoDB

// FK를 설정
    alter table employee
       add constraint FKfow2bhgypdy2ij4oyukrn6cqw
       foreign key (dept_id)
       references dept (dept_id)
 */
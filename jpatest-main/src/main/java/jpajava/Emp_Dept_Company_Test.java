package jpajava;

import domain.Company;
import domain.Department;
import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Emp_Dept_Company_Test {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    System.out.println("트랜잭션 시작");
    try {
//      Company company = new Company();
//      company.setName("kosta");
//      em.persist(company);
//      System.out.println("company 생성");
//
//      Department dept = new Department();
//      dept.setDeptName("IT");
//      dept.setCompany(company);
//      em.persist(dept);
//      System.out.println("부서 생성");

      Employee emp = em.find(Employee.class, "202402");
      System.out.println(emp.getEmpName());
      System.out.println(emp.getDept().getClass());
      System.out.println("id 출력 전");
      System.out.println(emp.getDept().getDeptId());
      System.out.println("name 출력 전");
      System.out.println(emp.getDept().getDeptName());
      System.out.println(emp.getDept().getClass());

      System.out.println("커밋 전");
      tx.commit();
      System.out.println("커밋 후");
    } catch (Exception e) {
      tx.rollback();
    }

    System.out.println("트랜잭션 종료");
  }
}

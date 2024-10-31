package org.example.spring_data_jpa.employee.repository;

import org.example.spring_data_jpa.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpRepository extends JpaRepository<Employee, String> {
  List<Employee> findByEmpNameLike(String empName);
}

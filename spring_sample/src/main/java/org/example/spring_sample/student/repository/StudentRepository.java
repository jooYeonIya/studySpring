package org.example.spring_sample.student.repository;

import org.example.spring_sample.student.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {
  List<Student> findALl() throws SQLException;
  Student findById(int id);
  void update(Student student);
  int add(Student student);
  void delete(int id);
}

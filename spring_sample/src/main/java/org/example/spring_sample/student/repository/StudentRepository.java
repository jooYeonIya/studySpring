package org.example.spring_sample.student.repository;

import org.example.spring_sample.student.domain.Student;

import java.util.List;

public interface StudentRepository {
  List<Student> findALl();
  Student findById(int id);
  void update(Student student);
  int add(Student student);
  void delete(Student student);
}

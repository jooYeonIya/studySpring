package org.example.spring_sample.student.repository;

import org.example.spring_sample.student.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryMapImpl implements StudentRepository {
  private int seq = 1;
  private Map<Integer, Student> students;

  public StudentRepositoryMapImpl() {
    students = new HashMap<Integer, Student>();
    Student student = new Student(seq++, "hong", "aaa", "2020-20-20", "a@a.com");
    students.put(1, student);
  }

  @Override
  public List<Student> findALl() {
    return new ArrayList<>(students.values());
  }

  @Override
  public Student findById(int id) {
    return students.get(id);
  }

  @Override
  public void update(Student student) {
    students.put(student.getId(), student);
  }

  @Override
  public int add(Student student) {
    student.setId(seq++);
    students.put(student.getId(), student);
    return student.getId();
  }

  @Override
  public void delete(int id) {
    students.remove(id);
  }
}

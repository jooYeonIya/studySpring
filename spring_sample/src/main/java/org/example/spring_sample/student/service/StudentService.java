package org.example.spring_sample.student.service;

import org.example.spring_sample.student.domain.Student;
import org.example.spring_sample.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// 컨트롤러와 리포지토리의 중간 단계
@Service
public class StudentService {
  StudentRepository repository;

  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> getAllStudents() {
    return repository.findALl();
  }

  public Student getStudentById(int id) {
    return repository.findById(id);
  }

  public Student createNew(Student student) {
    int id = repository.add(student);
    student.setId(id);
    return student;
  }

  public Student update(int id, Student student) {
    Student oldStudent = repository.findById(id);
    oldStudent.setUniv(student.getUniv());
    oldStudent.setEmail(student.getEmail());
    return oldStudent;
  }

  public void delete(int id) {
    repository.delete(id);
  }
}

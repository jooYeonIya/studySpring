package org.example.spring_sample.student.service;

import org.example.spring_sample.student.domain.Student;
import org.example.spring_sample.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

// 컨트롤러와 리포지토리의 중간 단계
@Service
public class StudentService {
  StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> getAllStudents() throws SQLException {
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

    if (oldStudent.getUniv() != null) {
      oldStudent.setUniv(student.getUniv());
    }

    if (oldStudent.getEmail() != null) {
      oldStudent.setEmail(student.getEmail());
    }

    repository.update(oldStudent);

    return oldStudent;
  }

  public void delete(int id) {
    repository.delete(id);
  }
}

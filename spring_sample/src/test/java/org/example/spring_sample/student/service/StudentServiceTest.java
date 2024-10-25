package org.example.spring_sample.student.service;

import org.example.spring_sample.student.domain.Student;
import org.example.spring_sample.student.repository.StudentRepositoryMapImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
  StudentRepositoryMapImpl studentRepositoryMap = new StudentRepositoryMapImpl();
  StudentService studentService = new StudentService(studentRepositoryMap);

  @Test
  void getAllStudents() {
    //ginve
    //when
    List<Student> allStudents = studentService.getAllStudents();

    //then
    assertEquals(1, allStudents.size());
  }
}
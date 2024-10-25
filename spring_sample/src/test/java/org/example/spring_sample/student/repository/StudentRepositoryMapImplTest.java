package org.example.spring_sample.student.repository;

import org.example.spring_sample.student.domain.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryMapImplTest {

  StudentRepositoryMapImpl studentRepositoryMap = new StudentRepositoryMapImpl();

  @Test
  void findALl() {
    // given

    // when 데이터를 가져왔을 때
    List<Student> all = studentRepositoryMap.findALl();

    // then 1개이면 성공
    assertEquals(all.size(), 1);
  }

  @Test
  void findById() {
   Student student = studentRepositoryMap.findById(1);
   Assertions.assertThat(student.getName()).isEqualTo("hong");
  }

  @Test
  void update() {
  }

  @Test
  void add() {
  }

  @Test
  void delete() {
  }
}
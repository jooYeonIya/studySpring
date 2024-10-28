package org.example.spring_sample.student.controller;

import lombok.AllArgsConstructor;
import org.example.spring_sample.student.domain.Student;
import org.example.spring_sample.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
  // 필드 방식으로 주업 -> 이 때는 Controller의 생성자 필요 없음 & final 못 씀 (왜냐면 처음에 초기값을 줘야 하는데 안 주니까)
  // @Autowired
  final StudentService service;

  // 생성자 주입
  // final 사용 가능 (생성자를 통해 초기값을 준다고 설정해놔서?)
  @Autowired
  public StudentController(StudentService studentService) {
    this.service = studentService;
  }

  @GetMapping
  public List<Student> getStudents() throws SQLException {
    return service.getAllStudents();
  }

  @GetMapping("/{id}")
  public Student getStudent(@PathVariable("id") int id) {
    return service.getStudentById(id);
  }

  @PutMapping("/{id}")
  public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
    Student student1 = service.update(id, student);
    return student1;
  }

  @PatchMapping("/{id}")
  public Student updateStudent2(@PathVariable("id") int id, @RequestBody Student student) {
    Student student1 = service.update(id, student);
    return student1;
  }

  @PostMapping
  public Student createStudent(@RequestBody Student student) {
    Student newStudent = service.createNew(student);
    return newStudent;
  }

  @DeleteMapping("/{id}")
  public void deleteStudent(@PathVariable("id") int id) {
    service.delete(id);
  }
}

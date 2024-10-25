package org.example.spring_sample.student.controller;

import org.example.spring_sample.student.domain.Student;
import org.example.spring_sample.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
  StudentService service;

  public StudentController(StudentService studentService) {
    this.service = studentService;
  }

  @GetMapping
  public List<Student> getStudents() {
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

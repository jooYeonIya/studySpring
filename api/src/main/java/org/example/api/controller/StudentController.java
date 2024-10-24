package org.example.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
  @GetMapping
  public String getAllStudents() {
    return "모든 학생 조회";
  }

  @PostMapping
  public String createStudent() {
    return "학생 추가";
  }
}

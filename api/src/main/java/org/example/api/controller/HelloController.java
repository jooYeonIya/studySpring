package org.example.api.controller;

import org.springframework.web.bind.annotation.*;


//@RestController 만 쓰면   @ResponseBody + @Controller 와 같은 효과
@RestController
@RequestMapping("/hello")
public class HelloController {

  @GetMapping
  public String hello() {
    return "hello get";
  }

  @PostMapping
  public String hello2() {
    return "hello post";
  }

  @PutMapping
  public String hello3() {
    return "hello put";
  }

  @PatchMapping
  public String hello4() {
    return "hello patch";
  }

  @DeleteMapping
  public String hello5() {
    return "hello delete";
  }
}


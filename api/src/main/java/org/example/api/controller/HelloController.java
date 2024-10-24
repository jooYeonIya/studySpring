package org.example.api.controller;

import org.springframework.web.bind.annotation.*;

//@RestController 만 쓰면   @ResponseBody + @Controller 와 같은 효과
@RestController
@RequestMapping("/hello")
public class HelloController {

//  @GetMapping
//  public String hello() {
//    return "hello get";
//  }

  @GetMapping
//  public String getParam(@RequestParam(value = "msg", required = false, defaultValue = "default") String msg) { // /hello?msg="asdfasdf"
  // msg 같으면 생략 가능
  public String getParam(@RequestParam(required = false, defaultValue = "default") String msg) {
    return "hello get param" + msg;
  }

  @GetMapping("/{msg}")
  public String getPath(@PathVariable("msg") String msg) { // /hello/{msg}
    return "hello get path" + msg;
  }

//  @PostMapping
//  public String hello2() {
//    return "hello post";
//  }

//  @PostMapping
//  public String hello2(@RequestParam String name, @RequestParam int age) {
//    return "hello post " + name + " " + age;
//  }

  // 포스트맨에서 json을 써서 ModelAttribute 매핑은 되지 않는다
  @PostMapping
  public String hello2(@RequestBody Person person) {
    return "hello post " + person.getName() + " " + person.getAge();
  }

//  @PutMapping
//  public String hello3() {
//    return "hello put";
//  }

  @PutMapping
  public String hello(@ModelAttribute Person person) {
    return "hello post " + person.getName() + " " + person.getAge();
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


package org.example.template_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//이제는 Veiw로 보내준다
@Controller
public class TestController {

  @GetMapping("/text")
  public String text(Model model) {
    model.addAttribute("data", "hello world");
    return "text"; // templates/text.html로 보내 라는 의미
  }
}

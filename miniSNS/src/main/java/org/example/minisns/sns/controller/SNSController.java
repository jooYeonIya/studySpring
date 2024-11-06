package org.example.minisns.sns.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.minisns.sns.domain.SNS;
import org.example.minisns.sns.domain.SNSCreateRequestDto;
import org.example.minisns.sns.domain.SNSDetailResponseDto;
import org.example.minisns.sns.domain.SNSUpdateRequestDto;
import org.example.minisns.sns.service.SNSService;
import org.example.minisns.user.domain.User;
import org.example.minisns.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class SNSController {
  private final SNSService snsService;
  private final UserService userService;

  //로그인 - 화면 표시
  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("loginInfo", new User());
    return "sns/login";
  }

  // 로그인 - DB 체크
  @PostMapping("/login")
  public String login(User userInfo, Model model, HttpServletRequest request, HttpServletResponse response) {
    boolean chekcedIDAndPassword = userService.isChekcedIDAndPassword(userInfo.getUserId(), userInfo.getPassword());
    if (chekcedIDAndPassword) {
      HttpSession session = request.getSession(true);
      session.setAttribute("userId", userInfo.getUserId());
      session.setMaxInactiveInterval(60);
      Cookie cookie = new Cookie("userId", userInfo.getUserId());
      response.addCookie(cookie);
      return "redirect:/posts/all";
    } else {
      return "sns/login";
    }
  }

  // 전체 목록 조회
  @GetMapping("/all")
  public String getAllSNS(Model model) {
    model.addAttribute("allSNS", snsService.getAllSNS());
    return "sns/all";
  }

  // 상세 조회
  @GetMapping("/{id}")
  public String getSNSById(@PathVariable("id") int id, Model model) {
    model.addAttribute("detail", snsService.getSNSById(id).get());
    return "sns/detail";
  }

  // 글 쓰기 - 화면 표시
  @GetMapping("/add")
  public String addSNS(Model model) {
    model.addAttribute("sns", new SNS());
    return "sns/add";
  }

  // 글 쓰기 - DB 작업
  @PostMapping("/add")
  public String createSNSWithUser(SNSCreateRequestDto sns) {
    snsService.createSNSWithUser("asdf", sns);
    return "redirect:/posts/all";
  }

  // 글 업데이트 - 화면 표시
  @GetMapping("/update/{id}")
  public String updateSNS(@PathVariable("id") int id, Model model) {
    model.addAttribute("sns", snsService.getSNSById(id).get());
    return "sns/update";
  }

  // 글 업데이트 - DB 작업
  @PostMapping("/update/{id}")
  public String updateSNS(@PathVariable("id") int id, SNSUpdateRequestDto sns) {
    snsService.updateSNS(id, sns);
    return "redirect:/posts/all";
  }

  // 글 삭제하기
  @RequestMapping("/delete/{id}")
  public String deleteSNS(@PathVariable("id") int id) {
    snsService.deleteSNSById(id);
    return "redirect:/posts/all";
  }

//  @PostMapping
//  public SNS createSNS(@RequestBody SNS sns) {
//    return snsService.save(sns);
//  }

  @GetMapping("/{id}/users/{userId}")
  public SNS getSNSWithUser(@PathVariable("id") int id, @PathVariable("userId") String userId) {
    return snsService.getSNSDetail(id);
  }

  // 쿼리DSL 사용
  @GetMapping("/SNSList")
  public List<SNSDetailResponseDto> getSNSList() {
    return snsService.getSNSByUserId("asdf");
  }
}

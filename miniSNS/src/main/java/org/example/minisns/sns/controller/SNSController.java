package org.example.minisns.sns.controller;

import lombok.RequiredArgsConstructor;
import org.example.minisns.sns.domain.SNS;
import org.example.minisns.sns.domain.SNSCreateRequestDto;
import org.example.minisns.sns.domain.SNSDetailResponseDto;
import org.example.minisns.sns.domain.SNSUpdateRequestDto;
import org.example.minisns.sns.service.SNSService;
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

  // 전체 목록 조회
  @GetMapping
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
    return "redirect:/posts";
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
    return "redirect:/posts";
  }

  // 글 삭제하기
  @RequestMapping("/delete/{id}")
  public String deleteSNS(@PathVariable("id") int id) {
    snsService.deleteSNSById(id);
    return "redirect:/posts";
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

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

  @GetMapping
  public String getAllSNS(Model model) {
    model.addAttribute("allSNS", snsService.getAllSNS());
    return "sns/all";
  }

//  @PostMapping
//  public SNS createSNS(@RequestBody SNS sns) {
//    return snsService.save(sns);
//  }

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

  @GetMapping("/{id}")
  public String getSNSById(@PathVariable("id") int id, Model model) {
    model.addAttribute("detail", snsService.getSNSById(id).get());
    return "sns/detail";
  }

  @GetMapping("/update/{id}")
  public String updateSNS(@PathVariable("id") int id, Model model) {
    model.addAttribute("sns", snsService.getSNSById(id).get());
    return "sns/update";
  }

  @PostMapping("/update/{id}")
  public String updateSNS(@PathVariable("id") int id, SNSUpdateRequestDto sns) {
    snsService.updateSNS(id, sns);
    return "redirect:/posts";
  }

  @DeleteMapping("/{id}")
  public void deleteSNS(@PathVariable("id") int id) {
    snsService.deleteSNSById(id);
  }


  @GetMapping("/{id}/users/{userId}")
  public SNS getSNSWithUser(@PathVariable("id") int id, @PathVariable("userId") String userId) {
    return snsService.getSNSDetail(id);
  }

  @GetMapping("/SNSList")
  public List<SNSDetailResponseDto> getSNSList() {
    return snsService.getSNSByUserId("asdf");
  }

//  @PatchMapping("/{id}/users/{userId}")
//  public SNSDetailResponseDto updateSNSWithUser(@PathVariable("id") int id,
//                                                @PathVariable("userId") String userId,
//                                                @RequestBody SNSUpdateRequestDto sns) {
//    return snsService.updateSNS(id, userId, sns);
//  }
//
//  @DeleteMapping("/{id}/users/{userId}")
//  public void deleteSNSWithUser(@PathVariable("id") int id, @PathVariable("userId") String userId) {
//    snsService.removeSNSWithUser(id, userId);
//  }
}

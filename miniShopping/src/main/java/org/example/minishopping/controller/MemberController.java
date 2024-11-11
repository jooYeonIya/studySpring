package org.example.minishopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.minishopping.dto.MemberCreateDto;
import org.example.minishopping.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping")
public class MemberController {
  private final MemberService memberService;

  // 멤버 생성
  @PostMapping("/add/member")
  public void addMember(MemberCreateDto dto) {
    memberService.addMember(dto);
  }
}

package org.example.minishopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.minishopping.dto.MemberCreateDto;
import org.example.minishopping.dto.MemberInquiryDto;
import org.example.minishopping.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping/member")
public class MemberController {
  private final MemberService memberService;

  // 멤버 생성
  @PostMapping("/add")
  public void addMember(MemberCreateDto dto) {
    memberService.addMember(dto);
  }

  // 전체 멤버 조회
  @GetMapping("/getAll")
  public List<MemberInquiryDto> getAllMembers() {
    return memberService.getAllMembers();
  }
}

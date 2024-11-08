package org.example.minishopping.service;

import org.assertj.core.api.Assertions;
import org.example.minishopping.dto.MemberInquiryDto;
import org.example.minishopping.entity.Member;
import org.example.minishopping.entity.status.MemberStatus;
import org.example.minishopping.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

  // test 는 필드 주입 가능
  @Autowired
  MemberService memberService;

  @Autowired
  MemberRepository memberRepository;

  @Test
  public void 전체회원정보조회() {
    // given
    Member member = new Member(0,
        "hong",
        "hongId",
        "1111",
        "hong@a.com",
        "00000000000",
        "ori",
        MemberStatus.A,
        LocalDate.now(),
        null);
    memberRepository.save(member);

    // when
    List<MemberInquiryDto> allMembers = memberService.getAllMembers();

    // then
    Assertions.assertThat(allMembers.size()).isEqualTo(1);
  }

}
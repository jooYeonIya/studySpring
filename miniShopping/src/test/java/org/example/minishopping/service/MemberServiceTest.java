package org.example.minishopping.service;

import org.assertj.core.api.Assertions;
import org.example.minishopping.dto.MemberCreateDto;
import org.example.minishopping.dto.MemberInquiryDto;
import org.example.minishopping.entity.Member;
import org.example.minishopping.entity.status.MemberStatus;
import org.example.minishopping.exception.NotUniqueUserIdException;
import org.example.minishopping.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
  public void 회원등록테스트() {
    MemberCreateDto memberCreateDto1 = new MemberCreateDto(
        "test",
        "testid",
        "1111",
        "e@mail.com",
        "0100000000",
        "ori");

    MemberCreateDto memberCreateDto2 = new MemberCreateDto(
        "test",
        "testid",
        "1111",
        "e@mail.com",
        "0100000000",
        "ori");

    Member member = memberService.addMember(memberCreateDto1);
    Optional<Member> optionalMember = memberRepository.findByUserId(member.getUserId());
    Assertions.assertThat(optionalMember.isPresent()).isTrue();

    assertThrows(NotUniqueUserIdException.class, () -> memberService.addMember(memberCreateDto2));
  }

  @Test
  public void 전체회원정보조회() {
    // given
    Member member = new Member(
        0,
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
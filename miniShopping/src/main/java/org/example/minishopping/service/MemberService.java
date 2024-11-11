package org.example.minishopping.service;

import lombok.RequiredArgsConstructor;
import org.example.minishopping.dto.MemberCreateDto;
import org.example.minishopping.dto.MemberInquiryDto;
import org.example.minishopping.entity.Member;
import org.example.minishopping.entity.status.MemberStatus;
import org.example.minishopping.exception.NotUniqueUserIdException;
import org.example.minishopping.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;

  // 멤버 생성
  public Member addMember(MemberCreateDto dto) {
    if (checkUniqueUserId(dto.getUserId())) {
      Member member = new Member(0,
          dto.getMemberName(),
          dto.getUserId(),
          dto.getPassword(),
          dto.getEmail(),
          dto.getPhone(),
          dto.getAddress(),
          MemberStatus.A,
          LocalDate.now(),
          null);

      return memberRepository.save(member);
    }

    return null;
  }

  public boolean checkUniqueUserId(String userId) {
    Optional<Member> optionalMember = memberRepository.findByUserId(userId);
    if (optionalMember.isPresent()) {
      throw new NotUniqueUserIdException("동일한 user id가 존재합니다");
    }
    return true;
  }

  // 전체 멤버 조회
  public List<MemberInquiryDto> getAllMembers() {
    List<Member> all = memberRepository.findAll();
    return all.stream()
        .map(MemberInquiryDto::of)
        .collect((Collectors.toList()));
  }

  // 멤버 상세 조회
  public MemberInquiryDto getOneMember(String memberId) {
    Optional<Member> optionalMember = memberRepository.findByUserId(memberId);
    if (optionalMember.isPresent()) {
      Member member = optionalMember.get();
      return MemberInquiryDto.of(member);
    }

    return null;
  }

  // 멤버 정보 수정
  // 멤버 삭제

}

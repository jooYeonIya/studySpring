package org.example.minishopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.minishopping.entity.Member;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberInquiryDto {
  private int memberId;
  private String memberName;
  private String userId;

  public static MemberInquiryDto of(Member member) {
    return new MemberInquiryDto(member.getMemberId(), member.getMemberName(), member.getUserId());
  }
}

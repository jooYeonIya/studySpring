package org.example.minishopping.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateDto {
  private String memberName;
  private String userId;
  private String password;
  private String email;
  private String phone;
  private String address;
}

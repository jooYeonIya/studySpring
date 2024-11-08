package org.example.minishopping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.minishopping.entity.status.MemberStatus;

import java.time.LocalDate;

// 고객
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int memberId;
  @Column(length = 20)
  private String memberName;
  @Column(length = 6)
  private String userId;
  @Column(length = 8)
  private String password;
  @Column(length = 30)
  private String email;
  @Column(length = 11)
  private String phone;
  @Column(length = 100)
  private String address;
  @Enumerated(EnumType.ORDINAL)
  private MemberStatus status;
  private LocalDate registrationDate;
  private LocalDate leaveData;

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public boolean changePassword(String password, String newPassword) {
    if (password.equals(this.password)) {
      this.password = newPassword;
      return true;
    } else {
      return false;
    }
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setAddress(String address) {
    this.address = address;

  }

  public void leave() {
    this.leaveData = LocalDate.now();
    this.status = MemberStatus.B;
  }

  @Override
  public String toString() {
    return "Member{" +
        "memberName='" + memberName + '\'' +
        ", userId='" + userId + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}

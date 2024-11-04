package org.example.minisns.sns.controller;

import lombok.RequiredArgsConstructor;
import org.example.minisns.sns.domain.SNS;
import org.example.minisns.sns.domain.SNSCreateRequestDto;
import org.example.minisns.sns.domain.SNSDetailResponseDto;
import org.example.minisns.sns.domain.SNSUpdateRequestDto;
import org.example.minisns.sns.service.SNSService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class SNSController {
  private final SNSService snsService;
//      • 선택한 글 삭제하기 : DELETE , http://localhost:8080/posts/1

  @GetMapping
  public List<SNS> getAllSNS() {
    return snsService.getAllSNS();
  }

  @PostMapping
  public SNS createSNS(@RequestBody SNS sns) {
    return snsService.save(sns);
  }

  @GetMapping("/{id}")
  public SNS getSNSById(@PathVariable("id") int id) {
    return snsService.getSNSById(id).get();
  }

  @PutMapping("/{id}")
  public SNS updateSNS(@PathVariable("id") int id, @RequestBody SNS sns) {
    return snsService.updateSNS(id, sns);
  }

  @DeleteMapping("/{id}")
  public void deleteSNS(@PathVariable("id") int id) {
    snsService.deleteSNSById(id);
  }

  @PostMapping("/users/{userId}")
  public SNSDetailResponseDto createSNSWithUser(@PathVariable("userId") String userId, @RequestBody SNSCreateRequestDto sns) {
    sns.setUserId(userId);
    return snsService.createSNSWithUser(sns);
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

package org.example.minisns.sns.controller;

import lombok.RequiredArgsConstructor;
import org.example.minisns.sns.domain.SNS;
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
}

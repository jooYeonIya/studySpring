package org.example.minisns.service;

import lombok.RequiredArgsConstructor;
import org.example.minisns.domain.SNS;
import org.example.minisns.repository.SNSRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

// 커밋과 롤백을 함
@Transactional
public class SNSService {
  private final SNSRepository snsRepository;

  // 커밋과 롤백을 안 함 (읽어오기만 함)
  @Transactional(readOnly = true)
  public List<SNS> getAllSNS() {
    return snsRepository.findAll();
  }

  public SNS save(SNS sns) {
    return snsRepository.save(sns);
  }

  @Transactional(readOnly = true)
  public Optional<SNS> getSNSById(String id) {
    return snsRepository.findById(id);
  }

  public SNS updateSNS(String id, SNS sns) {
    SNS findSns = snsRepository.findById(id).get();
    findSns.setBody(sns.getBody());
    // 없으면 추가, 있으면 수정
    return snsRepository.save(findSns);
  }

  public void deleteSNSById(String id) {
    snsRepository.deleteById(id);
  }
}

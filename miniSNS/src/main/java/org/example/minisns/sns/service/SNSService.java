package org.example.minisns.sns.service;

import lombok.RequiredArgsConstructor;
import org.example.minisns.sns.domain.SNS;
import org.example.minisns.sns.domain.SNSCreateRequestDto;
import org.example.minisns.sns.domain.SNSDetailResponseDto;
import org.example.minisns.sns.domain.SNSUpdateRequestDto;
import org.example.minisns.sns.repository.SNSRepository;
import org.example.minisns.user.domain.User;
import org.example.minisns.user.repository.UserRepository;
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
  private final UserRepository userRepository;

  // 커밋과 롤백을 안 함 (읽어오기만 함)
  @Transactional(readOnly = true)
  public List<SNS> getAllSNS() {
    return snsRepository.findAll();
  }

  public SNS save(SNS sns) {
    return snsRepository.save(sns);
  }

  @Transactional(readOnly = true)
  public Optional<SNS> getSNSById(int id) {
    return snsRepository.findById(id);
  }

  public SNS updateSNS(int id, SNSUpdateRequestDto sns) {
    SNS findSns = snsRepository.findById(id).get();
    findSns.setBody(sns.getBody());
    // 없으면 추가, 있으면 수정
    return snsRepository.save(findSns);
  }

  public void deleteSNSById(int id) {
    snsRepository.deleteById(id);
  }

  public SNSDetailResponseDto createSNSWithUser(String userId, SNSCreateRequestDto sns) {
    User user = userRepository.findByUserId(userId);
    SNS newSns = new SNS();
    newSns.setTitle(sns.getTitle());
    newSns.setBody(sns.getBody());
    newSns.setUser(user);
    newSns = snsRepository.save(newSns);
    return new SNSDetailResponseDto(newSns.getId(), newSns.getTitle(), newSns.getBody(), newSns.getLikes(), newSns.getUser().getUserId());
  }

  public SNS getSNSDetail(int id) {
    SNS sns = snsRepository.findBySNSWithUserFetchjoin(id);
    return sns;
  }

  public List<SNSDetailResponseDto> getSNSByUserId(String userId) {
    return snsRepository.getByUserId(userId);
  }

//  public SNSDetailResponseDto updateSNS(int id, String userId, SNSUpdateRequestDto sns) {
//    SNS findSns = snsRepository.findById(id).get();
//
//    if(findSns.getUser().getUserId().equals(userId)) {
//
//    }
//  }
//
//  public void removeSNSWithUser(int id, String userId) {
//
//  }
}

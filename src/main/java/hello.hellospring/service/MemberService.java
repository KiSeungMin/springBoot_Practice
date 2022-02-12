package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemberRepository;

import.java.util.List;
import.java.util.Optional;

public class MemberService{

  private final MemberRepository MemberRepository;
  
  public MemberService(MemberRepository memberRepository){
    this.memberRepository = memberRepository;
  }

  // 회원가입
  public Long join(Member member){

    validateDuplicateMember(member);    // 중복 회원 검증
    MemberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicateMember(Member member){
    
    // 같은 이름이 있는 중복 회원X
    // ifPresent는 null이 아닐 경우 실행하는 Optional의 함수이다.

    MemberRepository.findByName(member.getName())
        .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
  }

  // 전체 회원 조회
  public List<Member> findMembers(){
    return MemberRepository.findAll();
  }

  // ID로 회원 조회
  public Optional<Member> findOne(Long memberId){
    return MemberRepository.findById(memberId);
  }

}
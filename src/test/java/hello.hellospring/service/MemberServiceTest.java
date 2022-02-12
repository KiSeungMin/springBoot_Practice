package hello.hellospring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class MemberServiceTest{

  MemberService memberService = new MemberService();
  MemoryMemberRepository MemberRepository;

  @BeforeEach // 함수가 시작하기 전에 실행
  public void beforeEach(){

    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }

  @AfterEach //함수가 끝날 때마다 실행
  public void afterEach(){
    memberRepository.clearStore();
  }

  @Test
  void join(){

    // given
    Member member = new Member();
    member.setName("hello");

    //when
    Long saveId = memberService.join(member);
  
    // then
    Member findMember = memberService.findOne(saveId).get();
    //assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  // 중복 회원이 있을 경우
  @Test
  public void exceptJoin(){
    
    //given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    memberService.join(member1);

    //IllegalStateException e =  assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    /*
    try{
      memberService.join(member2);
    } catch(IllegalStateException e){
      //assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
    */
    
  }

  @Test
  void findMembers(){

  }

  @Test
  void findOne(){

  }
}
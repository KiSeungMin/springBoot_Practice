package hello.hellospring.repository;

import hello.hellospring.domain.Member;

public interface MemberRepository{

  Member save(Member member);   // save를 할 경우 member로 저장됨
  Optional<Member> findById(Long id);   // 저장된 member를 ID값으로 찾음
  Optional<Member> findByName(String name);   // 저장된 member를 name으로 찾음
  List<Member> findAll();   // 저장된 모든 member를 List로 반환
}
package hello.hellospring.repository;

import java.util.Optional;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();   // 키와 값으로 저장
    private static long sequence = 0L;    // 멤버 수를 세는 변수

    @Override
    public Member save(Member member){
      member.setId(++sequence);
      store.put(member.getId(), member);
      return member;
    }

    @Override
    public Optional<Member> findById(Long id){
      return Optional.ofNullable(store.get(id));    // Optional.ofNullable을 사용해 null값이 반환될 경우를 대비한다.
    }

    @Override
    public Optional<Member> findByName(String name){
      store.values().stream()
        .filter(member -> member.getName().equals(name))
        .findAny();
    }

    public List<Member> findAll(){
      return new ArrayList<>(store.values());
    }
    
    public void clearStore(){
      store.clear();
    }
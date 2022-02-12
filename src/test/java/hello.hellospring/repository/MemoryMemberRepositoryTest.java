package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest{

  MemoryMemberRepository repository = new MemoryMemberRepository();

  @AfterEach  //함수가 끝날 때마다 실행
  public void afterEach(){
      repository.clearStore();
  }
  

  @Test     // 아래의 메서드를 gradle 빌드까지 하지 않고 그냥 실행 
  public void save(){

    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Member result = repository.findById(member.getID());

    //System.out.println("result = " + (result == member));   -> true

    //Assertions.assertEquals(result, member);    // 동일한지 확인하는 메서드

    //Assertions.assertThat(member).isEqualTo(result);
  }

  @Test
  public void findByName(){

    Member member1 = new Member();
    member1.setname("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);
  
    Member result = repository.findByName("spring1").get();

    //assertThat(result).isEqualTo(member1);
  }

  @Test
  public void findAll(){
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    List<Member> result = repository.findAll();

    //assertThat(result.size()).isEqualTo(2);
  }
}
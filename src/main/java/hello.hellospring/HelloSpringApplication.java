package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링부트는 자동으로 index.html을 찾아 실행한다.
// 스프링부트는 내장 서버인 톰캣을 실행시킨다.
// 스프링부트와 관련된 라이브러리를 쓰면 의존관계에 의해 다른 라이브러리까지 실행된다.
@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloSpringApplication.class, args);
	}

}

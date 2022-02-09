package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HelloController {

    @GetMapping("hello")    // /hello라는 명령(페이지)이 들어오면 아래의 명령을 실행한다.
    public String hello(Model model){

        // hello.html로 전달
        model.addAttribute("data", "hello!!");  // attributeName : 모델의 키값, attributeValue : 모델의 value
        return "hello"; // hello.html로 전달
    }
}

package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 스프링 엔진은 웹페이지 요청이 들어왔을 때 먼저 controller에 관련 파일이 있는지 찾아본다.
// 만약 controller가 없다면 static 폴더에서 해당 파일을 찾는다.
// Controller는 웹 MVC의 컨트롤러 역할을 한다.

@Controller

public class HelloController {

    @GetMapping("hello")    // /hello라는 명령(페이지)이 들어오면 아래의 명령을 실행한다.
    public String hello(Model model){   // model은 mvc의 모델을 뜻한다.

        // hello.html로 전달
        model.addAttribute("data", "hello!!");  // attributeName : 모델의 키값, attributeValue : 모델의 value
        return "hello"; // viewResolver가 templates 폴더에서 hello.html을 찾아 렌더링하도록 함(타임리프 문법)
    }

    // mvc : Model, View, Controller의 줄임말
    // view에서는 보여지는 페이지를 담당한다.
    // 서버 딴에서의 일은 Controller가 담당한다.
    @GetMapping("hello-mvc")

    // @RequestParam은 외부에서 parameter를 받을 때 사용한다.
    // localhost:8080/hello-mvc?name=spring 이라고 입력하면, 해당 페이지에 hello spring이라고 뜨는 것을 볼 수 있다.
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);   // 키, 값
        return "hello-template";
    }

    @GetMapping("hello-string")
    @getResponseBody    // http의 body부분을 직접 넣겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;     // hello "name"
    }

    // api 방식은 객체를 반환하는 방식이다.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello  helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 객체(JSON 방식)를 전달
                              // 객체가 전달되면 viewResolver 대신 HttpMessageConverter가 JsonConverter 혹은 StringConverter로 전달한다.
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}

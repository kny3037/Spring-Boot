package com.springboot.hello.controller;

import com.springboot.hello.domian.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
@Slf4j
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        log.info("hello로 요청이 들어왔습니다.");
        return "Hello World";
    }
    @GetMapping(value = "/name")
    public String getName(){
        log.info("name으로 요청이 들어왔습니다.");
        return "nayeong";
    }
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable(@PathVariable String variable){
        log.info("getVariable로 요청이 들어왔습니다.");
        return variable;
    }
    @GetMapping(value = "/request1")
    public String getVariable2(@RequestParam String name,@RequestParam String email, @RequestParam String organization ){

        return String.format("%s %s %s", name, email, organization);
    }
    @GetMapping(value = "/request2")
    public String getVariable2(@RequestParam Map<String, String> param){
        param.entrySet().forEach((map) ->{
            System.out.printf("key : %s value : %s",map.getKey(),map.getValue());
        });
        return "request2가 호출 완료 되었습니다!";
    }
    @GetMapping(value = "/request3")
    public String getRequestParam(MemberDto memberDto){
        return memberDto.toString();
    }
}


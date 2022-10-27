package com.springboot.hello.controller;

import com.springboot.hello.domian.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){

        return "Hello World";
    }
    @GetMapping(value = "/name")
    public String getName(){

        return "nayeong";
    }
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable(@PathVariable String variable){

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


package com.spring.velogcloneproject.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //리액트 연동 테스트
    @GetMapping("/test")
    public String hello(){
        return "백엔드 데이터 연동 확인";
    }
}

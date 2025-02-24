package com.moyeo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        return "통신 성공^____^";
    }

    @GetMapping("/api/test")
    public String test() {
        return "test";
    }
}

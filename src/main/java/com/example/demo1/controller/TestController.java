package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class TestController {

    @RequestMapping("/test1")
    public String test1() {
        System.out.println("11111111");
        return "/html/demo1";
    }
    @RequestMapping("/test2")
    public void test2() {
        System.out.println("aaaaaa");
        System.out.println("aaaaaa");
        System.out.println("aaaaaa");
    }

}

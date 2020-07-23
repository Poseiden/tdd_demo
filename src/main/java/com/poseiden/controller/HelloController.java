package com.poseiden.controller;

import com.poseiden.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Greetings from Spring Project Initial With Gradle!";
    }

    @GetMapping("/security")
    public String helloWithSecurity() {
        return "Greeting with security!";
    }

    @GetMapping("/result")
    public String resultForContract(@RequestParam String text) {
        return helloService.getTrueValue();
    }

}


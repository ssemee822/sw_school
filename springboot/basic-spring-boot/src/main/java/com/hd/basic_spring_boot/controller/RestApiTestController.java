package com.hd.basic_spring_boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiTestController {
    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    @GetMapping("/borad/{variale}")
    public String borad(@PathVariable("variale") String variale) {
        return variale;
    }

    @GetMapping("/req")
    public String getReqParam(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String company) {
        return name + " " + email + " " + company;
    }
}

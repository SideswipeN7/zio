package com.whynot.zio.servlets;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String getHelloTime(){
        return "Hello, current time is: " + LocalDateTime.now();
    }
}

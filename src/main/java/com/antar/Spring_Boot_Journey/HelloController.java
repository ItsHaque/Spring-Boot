package com.antar.Spring_Boot_Journey;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name){
        return "hello, " + name;
    }

    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b){
        return " " + (a+b);
    }

    @GetMapping("/greet-json/{name}")
    public Greetings greetings(@PathVariable String name, @RequestParam int code){
        return new Greetings("Greetings, " + name + "!", code);
    }
}

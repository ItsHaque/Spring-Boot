package com.antar.Spring_Boot_Journey;

import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/accounts")
//    public AccountRequest accountReq(@RequestBody AccountRequest accountRequest){
//        return accountRequest;
//    }
}

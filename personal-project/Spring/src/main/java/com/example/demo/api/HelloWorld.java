package com.example.demo.api;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.TEXT_HTML_VALUE;
@RestController
@RequestMapping(value = "/hello", produces = TEXT_HTML_VALUE)

public class HelloWorld {
    @GetMapping("")
    public String getGreeting(
        @RequestParam(required = false, defaultValue = "World") String name){
        return "Hello "+name;
    }

    @GetMapping("/{name}")
    public String getGreetingPath(@PathVariable("name") String name){
        return "Hello " + name;
    }

}

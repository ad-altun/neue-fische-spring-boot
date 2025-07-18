package org.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello/{name}")
public class HelloSomeoneController {

    @GetMapping
    public String greetSomeone(@PathVariable String name) {
        return "Hello " + name;
    }
}

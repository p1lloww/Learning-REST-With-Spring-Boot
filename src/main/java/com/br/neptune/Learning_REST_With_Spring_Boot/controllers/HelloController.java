package com.br.neptune.Learning_REST_With_Spring_Boot.controllers;

import com.br.neptune.Learning_REST_With_Spring_Boot.model.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Hello hello(
            @RequestParam(value = "name", defaultValue = "World")
            String name) {
        return new Hello(counter.incrementAndGet(), String.format(template, name));
    }
}

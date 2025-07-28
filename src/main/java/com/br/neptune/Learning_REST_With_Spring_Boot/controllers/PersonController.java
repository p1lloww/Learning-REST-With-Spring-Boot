package com.br.neptune.Learning_REST_With_Spring_Boot.controllers;

import com.br.neptune.Learning_REST_With_Spring_Boot.PersonServices;
import com.br.neptune.Learning_REST_With_Spring_Boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping("/findAll")
    public List<Person> findAll() {
        return service.findAll();
    }

}

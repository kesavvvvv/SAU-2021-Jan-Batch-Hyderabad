package com.accolite.learningRest.controllers;

import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String showWelcomeMessage() {
        return "Welcome!";
    }
    @GetMapping("/add")
    public int addition(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return num1+num2;
    }
    @GetMapping("/multiply/{num1}/{num2}")
    public int multiply(@PathVariable Integer num1, @PathVariable Integer num2) {
        return num1*num2;
    }
}

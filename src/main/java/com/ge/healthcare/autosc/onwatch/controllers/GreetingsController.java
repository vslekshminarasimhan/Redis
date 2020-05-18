package com.ge.healthcare.autosc.onwatch.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class GreetingsController {
   
	@GetMapping("/greetings")
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(String name) {
        return "Greetings API Updated for AutoSc OnWatch Project";
    }
}

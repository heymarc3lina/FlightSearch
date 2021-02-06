package com.example.flightsercher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FlightSection {

    @GetMapping("/hello")
    public  String sayHello(){
        return "hello people" ;
    }

    @GetMapping("/flights")
    public String list(){


        return "flights";
    }

}
package com.example.flightsercher.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminSection {


    @GetMapping("/adminPage")
    public String showAdminPage(){
        return "adminPage";
    }
}

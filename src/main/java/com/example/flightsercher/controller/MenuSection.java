package com.example.flightsercher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuSection {

    @RequestMapping("/menuSection")
    public String section(){
        return "menuSection";
    }
}

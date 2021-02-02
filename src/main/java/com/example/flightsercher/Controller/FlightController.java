package com.example.flightsercher.Controller;


import com.example.flightsercher.Model.Flight;

import com.example.flightsercher.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class FlightController {
  

    @GetMapping("hello")
    public  String sayHello(){
        return "hello" ;
    }

    @GetMapping("/flightSection/")
    public String section(){
        return "flightSection";
    }

    @GetMapping("/flightSection/flights")
    public String list(Model model){


        return "flights";
    }
}

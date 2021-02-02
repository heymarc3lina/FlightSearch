package com.example.flightsercher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class FlightsercherApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightsercherApplication.class, args);
    }


    @GetMapping("/hello")
    public  String sayHello(){
        return "hello" ;
    }

}

package com.example.flightsercher.controller;

import com.example.flightsercher.Model.Flight;
import com.example.flightsercher.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FlightSection {

    @Autowired
    FlightService flightService;

    @GetMapping("/hello")
    public  String sayHello(){
        return "hello people" ;
    }

    @GetMapping("/flights")
    public String list(Model model){

        model.addAttribute("flights", flightService.list());
        return "flights";
    }

    @GetMapping("/chosenFlights")
    //@ResponseBody
    public String listForChosen(@RequestParam String arrival, @RequestParam String departure, Model model ){
        List<Flight>  chosenFlightList = new ArrayList<>();
        for(Flight flight : flightService.list()){
            if(flight.getArrival().equalsIgnoreCase(arrival) && flight.getDeparture().equalsIgnoreCase(departure)){
                chosenFlightList.add(flight);
            }
        }

        model.addAttribute("flights", chosenFlightList);
        return "flights";
    }

    @GetMapping("/addNewFlight")
    public  String addNewFlight(){
        return "addNewFlight";
    }

    @PostMapping("/addingNewFlight")
    public String addFlight(@RequestParam String arrival, @RequestParam String departure ,@RequestParam String price, @RequestParam String flightTime){
        Flight flight = new Flight(arrival, departure, Float.parseFloat(price),Float.parseFloat(flightTime));
        flightService.addFlight(flight);
        return "menuSection";

    }

}

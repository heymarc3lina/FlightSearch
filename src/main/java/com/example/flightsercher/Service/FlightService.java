package com.example.flightsercher.Service;

import com.example.flightsercher.Model.Flight;
import com.example.flightsercher.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    public List<Flight> list(){
        return flightRepository.findAll();
    }
//    public List<Flight> listForChosen(String arrival, String departure){
//        List<Flight> chosenFlight = new ArrayList<>();
//        for(Flight flight : )
//
//    }
    public void addFlight(Flight flight){
        this.flightRepository.save(flight);
    }


    public Flight getFlightById(String id){
       Flight flight =  flightRepository.findById(Long.parseLong(id)).orElse(null);
       return flight;
    }

    public void updateFlight(String id, String arrival, String departure, String price, String time){
        Flight flight = flightRepository.getOne(Long.parseLong(id));
        flight.setArrival(arrival);
        flight.setDeparture(departure);
        flight.setPrice(Float.parseFloat(price));
        flight.setFlightTime(Float.parseFloat(time));
        this.flightRepository.saveAndFlush(flight);
    }

}

package com.example.flightsercher.Service;

import com.example.flightsercher.Model.Flight;
import com.example.flightsercher.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}

package com.example.flightsercher.Service;


import com.example.flightsercher.Model.Passenger;
import com.example.flightsercher.Repository.FlightRepository;
import com.example.flightsercher.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }


    public List<Passenger> list(){
        return passengerRepository.findAll();
    }
}

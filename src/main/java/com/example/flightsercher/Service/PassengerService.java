package com.example.flightsercher.Service;


import com.example.flightsercher.Model.Passenger;
import com.example.flightsercher.Model.Role;
import com.example.flightsercher.Repository.PassengerRepository;
import com.example.flightsercher.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class PassengerService {

    private PassengerRepository passengerRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private RoleRepository roleRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.passengerRepository = passengerRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Passenger saveUser(Passenger passenger){
        passenger.setPassword(bCryptPasswordEncoder.encode(passenger.getPassword()));
        passenger.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        passenger.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return passengerRepository.save(passenger);
    };

    public Passenger findPassengerByEmail(String email){
        return passengerRepository.findByEmail(email);
    };

    public List<Passenger> list(){
        return passengerRepository.findAll();
    }
}

package com.example.flightsercher.Repository;

import com.example.flightsercher.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}

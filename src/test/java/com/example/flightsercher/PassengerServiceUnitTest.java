package com.example.flightsercher;

import com.example.flightsercher.Model.Flight;
import com.example.flightsercher.Model.Passenger;
import com.example.flightsercher.Service.FlightService;
import com.example.flightsercher.Service.PassengerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassengerServiceUnitTest {


    @Autowired
    private PassengerService passengerService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Passenger> passengers = passengerService.list();

        Assert.assertEquals(2, passengers.size());
    }
}

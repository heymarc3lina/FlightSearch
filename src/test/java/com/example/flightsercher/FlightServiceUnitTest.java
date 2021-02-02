package com.example.flightsercher;

import com.example.flightsercher.Model.Flight;
import com.example.flightsercher.Service.FlightService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightServiceUnitTest {

    @Autowired
    private FlightService flightService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Flight> flights = flightService.list();

        Assert.assertEquals(2, flights.size());
    }


}

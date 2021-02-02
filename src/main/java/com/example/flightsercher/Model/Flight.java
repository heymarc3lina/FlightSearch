package com.example.flightsercher.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    private String arrival, deprature;
    private float price;
    private float flightTime;

    public Flight() {
    }

    public Flight( String arrival, String deprature, float price, float flightTime) {
        this.arrival = arrival;
        this.deprature = deprature;
        this.price = price;
        this.flightTime = flightTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeprature() {
        return deprature;
    }

    public void setDeprature(String deprature) {
        this.deprature = deprature;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(float flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id +", arrival=" + arrival+ ", departure=" + deprature +", price="+price +
    ", flightTime=" + flightTime + "}" ;
    }
}

package com.example.flightsercher.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String arrival, departure;
    private float price;
    private float flightTime;

    public Flight() {
    }

    public Flight( String arrival, String departure, float price, float flightTime) {
        this.arrival = arrival;
        this.departure = departure;
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

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
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
        return "Flight{" + "id=" + id +", arrival=" + arrival+ ", departure=" + departure +", price="+price +
    ", flightTime=" + flightTime + "}" ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result =  prime*result+((id == null)? 0: id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flight other = (Flight) obj;
        if (this.id == null) {
            if(other.id != null){
                return false;
            }
        }else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}

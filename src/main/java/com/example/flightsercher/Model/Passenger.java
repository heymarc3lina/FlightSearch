package com.example.flightsercher.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passenger {

    @Id
    @GeneratedValue
    private Long id;
    String name, lastName;
    String passpordNumber;

    public Passenger() {
    }

    public Passenger(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasspordNumber() {
        return passpordNumber;
    }

    public void setPasspordNumber(String passpordNumber) {
        this.passpordNumber = passpordNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" + "id=" + id +", name=" + name+ ", lastName=" + lastName +", passport number="+passpordNumber + "}" ;
    }
}

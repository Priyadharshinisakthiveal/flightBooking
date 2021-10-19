package com.flight.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="passenger")
public class Passengers {
	@Id
    @GeneratedValue
    private int passengerId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    
    
    private String passportNumber;
    
    @Email
    private String email;

    private String address;
    
    private int flightId;

    public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	@ManyToOne
    private Flight flight;
    
	//default constructor
    public Passengers() {
    }
   
    //parametrized constructor
    public Passengers( String firstName, String lastName,  String passportNumber, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.email = email;
        this.address = address;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @JsonIgnore
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

}

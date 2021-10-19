package com.flight.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="flight")
public class Flight {
	@Id
    @GeneratedValue
    private long flightId;
    private String flightNumber;
    private String flightName;

	@ManyToOne
    private Airport departureAirport;
    @ManyToOne
    private Airport destinationAirport;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    private String departureTime;

    private String arrivalTime;

    private double flightCharge;
    
    private String DepartureAirportCode;
    
    private String DestinationAirportCode;

    public String getDepartureAirportCode() {
		return DepartureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		DepartureAirportCode = departureAirportCode;
	}

	public String getDestinationAirportCode() {
		return DestinationAirportCode;
	}


	public void setDestinationAirportCode(String destinationAirportCode) {
		DestinationAirportCode = destinationAirportCode;
	}

	@OneToMany(mappedBy = "flight")
    List<Passengers> passengers = new ArrayList<>();
    
	//default constructor
	public Flight() {
		
	}
	
    public Flight(int i, String string, String string2) {
    	this.flightId = i;
    	this.flightNumber=string;
    	this.flightName=string2;
    }

   
    public Flight(String flightNumber, Airport departureAirport, Airport destinationAirport,
                  double flightCharge, LocalDate departureDate, LocalDate arrivalDate) {

        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.flightCharge = flightCharge;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    @JsonIgnore
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }
    @JsonIgnore
    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    
    public String getFlightName() {
		return flightName;
	}



	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getFlightCharge() {
        return flightCharge;
    }

    public void setFlightCharge(double flightCharge) {
        this.flightCharge = flightCharge;
    }
    @JsonIgnore
    public List<Passengers> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passengers> passengers) {
        this.passengers = passengers;
    }
}



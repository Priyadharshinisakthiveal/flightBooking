package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flight.entities.Flight;
import com.flight.entities.Passengers;
import com.flight.service.FlightServiceImpl;
import com.flight.service.PassengerServiceImpl;

//Main Controller to perform get, post and delete operations of flight

@RestController
@RequestMapping("/api/v1.0/flight")
public class FlightController {
	
	@Autowired
	FlightServiceImpl flightservice;
	
	@Autowired
	PassengerServiceImpl passengerservice;
	
	//Getting all the flight route details
	@GetMapping("/airline/flightList")
	public List<Flight> getAllFlights(){
		return flightservice.getAllFlights();
	}
	
	//adding new flight route to the system.
	@PostMapping("/addFlight")
	@ResponseStatus(HttpStatus.CREATED)
	public Flight addFlight(@RequestBody Flight flight) {
		return flightservice.saveFlight(flight);
	}
	
	//getting flight route by unique id.
	@GetMapping("/airline/getflightId/{flightId}")
	public Flight getFlightById(@PathVariable Long flightId) {
		return flightservice.getFlightById(flightId);
	}
	
	//booking a flight ticket by the passenger.
	@PostMapping("/managebooking")
	@ResponseStatus(HttpStatus.CREATED)
	public Passengers BookingFlight(@RequestBody Passengers passenger) {
		return passengerservice.savePassenger(passenger);
	}
	
	//deleting specific flight route by its Id.
	@DeleteMapping("/deleteFlight/{flightId}")
	public ResponseEntity<String> DeleteFlightRoute(@PathVariable Long flightId) {
		 boolean flag = flightservice.deleteFlightById(flightId);
		 if(flag)
				return new ResponseEntity<>("flight deleted successfully",HttpStatus.OK);
			else
				return new ResponseEntity<>("No flight with the Id found",HttpStatus.BAD_REQUEST);
		}
	
	
	

}

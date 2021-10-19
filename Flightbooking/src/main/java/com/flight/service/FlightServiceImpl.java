package com.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.repository.FlightRepository;
import com.flight.entities.Flight;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

	@Override
	public Flight getFlightById(long flightId) {
		return flightRepository.findById(flightId).orElse(null);
	}

	@Override
	public Flight saveFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public boolean deleteFlightById(long flightId) {
		flightRepository.deleteById(flightId);
		return true;
	}




}

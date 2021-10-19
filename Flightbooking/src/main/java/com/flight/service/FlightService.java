package com.flight.service;


import java.util.List;
import com.flight.entities.Flight;

public interface FlightService {
	public abstract List<Flight> getAllFlights();
	public abstract Flight getFlightById(long flightId);
    public abstract Flight saveFlight(Flight flight);
    public abstract boolean deleteFlightById(long flightId);

}

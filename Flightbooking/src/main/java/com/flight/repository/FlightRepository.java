package com.flight.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entities.Airport;
import com.flight.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight,Long> {
	List<Flight> findAllByDepartureAirportEqualsAndDestinationAirportEqualsAndDepartureDateEquals(Airport depAirport, Airport destAirport, LocalDate depDate);

}

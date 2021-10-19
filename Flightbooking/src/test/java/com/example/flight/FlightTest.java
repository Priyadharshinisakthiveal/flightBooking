package com.example.flight;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.flight.service.*;
import com.flight.entities.*;
import com.flight.repository.*;

@ExtendWith(MockitoExtension.class)
public class FlightTest {
	
	@Mock
	private FlightRepository repository;
	
	@InjectMocks
	private FlightServiceImpl service;
	
	@Test
	void getAllFlights(){
		List<Flight> list = new ArrayList<Flight>(); 
		
		Flight flight = new Flight(12,"BE123","AirIndia");
		
		list.add(flight);
		
       when(repository.findAll()).thenReturn(list);
		
		List<Flight> flightList = service.getAllFlights();
		assertEquals(2,flightList.size());	
		
	}
	
	@Test
	void saveFlightTest() {
		Flight flight = new Flight(1,"BE178","airindia");
		when(repository.save(flight)).thenReturn(flight);
		Flight savedflight = service.saveFlight(f1);
		assertThat(savedflight).isNotNull();
		assertEquals("airindia",savedflight.getFlightName());
	}
	
	@Test
	public void deleteFlightTest() {
		Flight flight = new Flight(1,"BE123","indigo");
		repository.deleteById(flight.getFlightId());
		boolean deleteflight = service.deleteFlightById(1);
		assertThat(deleteflight).isNotNull();
		assertEquals(true,deleteflight);
		
	}
	

}

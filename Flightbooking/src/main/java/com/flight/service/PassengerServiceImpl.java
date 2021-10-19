package com.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.entities.Passengers;
import com.flight.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService{
	@Autowired
	private PassengerRepository passengerRepository;
	

    @Override
    public Passengers savePassenger(Passengers passenger) {
        return passengerRepository.save(passenger);
    }

}

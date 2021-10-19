package com.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entities.*;

public interface PassengerRepository extends JpaRepository<Passengers,Long>{

}

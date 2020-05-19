package com.springboot.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.data.entity.Flight;

public interface FlightRepository extends CrudRepository<Flight, Long> {

}

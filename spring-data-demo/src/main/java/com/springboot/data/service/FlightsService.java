package com.springboot.data.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.data.entity.Flight;
import com.springboot.data.repository.FlightRepository;

@Component
public class FlightsService {
	private final FlightRepository flightRepository;

	public FlightsService(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	public void saveFlight(Flight flight) {
		flightRepository.save(flight);
		// some other queries and method calls here maybe
		throw new RuntimeException("I failed");
	}

	@Transactional
	public void saveFlightTransactional(Flight flight) {
		flightRepository.save(flight);
		// some other queries and method calls here maybe
		throw new RuntimeException("I failed");
	}
}

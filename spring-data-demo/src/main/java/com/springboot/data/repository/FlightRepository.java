package com.springboot.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.data.entity.Flight;

public interface FlightRepository extends PagingAndSortingRepository<Flight, Long> {

	List<Flight> findByOrigin(String origin);

	List<Flight> findByOriginAndDestination(String origin, String destination);

	List<Flight> findByOriginIn(String... origins);

	List<Flight> findByOriginIgnoreCase(String origin);

	Page<Flight> findByOrigin(String origin, Pageable pageRequest);
}

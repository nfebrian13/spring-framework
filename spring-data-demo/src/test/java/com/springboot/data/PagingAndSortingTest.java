package com.springboot.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.data.entity.Flight;
import com.springboot.data.repository.FlightRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PagingAndSortingTest {

	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void verifyLightCanBeSaved() {
		final Flight flight = new Flight();
		flight.setOrigin("Amsterdam");
		flight.setDestination("New York");
		flight.setScheduledAt(LocalDateTime.parse("2020-12-13T12:12:00"));

		flightRepository.save(flight);
		
		assertThat(flightRepository.findAll())
		.hasSize(1)
		.first()
		.isEqualToComparingFieldByField(flight);
		
		flightRepository.deleteById(flight.getId());
		
		assertThat(flightRepository.count()).isZero();
		
	}
}

package com.springboot.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.data.entity.Flight;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringDataDemoApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Test
	public void verifyLightCanBeSaved() {
		final Flight flight = new Flight();
		flight.setOrigin("Amsterdam");
		flight.setDestination("New York");
		flight.setScheduledAt(LocalDateTime.parse("2020-12-13T12:12:00"));

		entityManager.persist(flight);

		final TypedQuery<Flight> results = entityManager.createQuery("SELECT f FROM f", Flight.class);
		final List<Flight> resultList = results.getResultList();
		
		assertThat(resultList)
		.hasSize(1)
		.first()
		.isEqualTo(flight);
	}
}

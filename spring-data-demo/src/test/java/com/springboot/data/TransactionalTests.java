package com.springboot.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.data.entity.Flight;
import com.springboot.data.repository.FlightRepository;
import com.springboot.data.service.FlightsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTests {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightsService flightsService;

    @Before
    public void setUp(){
        flightRepository.deleteAll();
    }

    @Test
    public void shouldNotRollBackWhenTheresNoTransaction() {
        try {
            flightsService.saveFlight(new Flight());
        } catch (Exception e) {
            // Do nothing
        }
        finally {
            assertThat(flightRepository.findAll())
                .isNotEmpty();
        }
    }

    @Test
    public void shouldNotRollBackWhenTheresIsATransaction() {
        try {
            flightsService.saveFlightTransactional(new Flight());
        } catch (Exception e) {
            // Do nothing
        }
        finally {
            assertThat(flightRepository.findAll())
                .isEmpty();
        }
    }

}

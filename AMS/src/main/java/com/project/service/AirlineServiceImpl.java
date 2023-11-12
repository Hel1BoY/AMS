package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.model.basemodel.Airline;
import com.project.repository.AirlineRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AirlineServiceImpl service class.
 * Implements AirlineService interface.
 */
@Service
public class AirlineServiceImpl implements AirlineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirlineService.class);

    @Autowired
    private AirlineRepo airlineRepo;

    /**
     * {@inheritDoc}
     * {@link com.project.service.AirlineService#retrieveAllAirlines()}.
     */
    @Override
    public List<Airline> retrieveAllAirlines() {
        final Optional<List<Airline>> airlines = Optional.ofNullable(this.airlineRepo.findAll());

        if(airlines.isPresent()) {
            return airlines.get();
        } else {
            LOGGER.error("No airlines found!");
            return new ArrayList<>();
        }
    }

}

package com.project.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.project.model.basemodel.Airport;
import com.project.repository.AirportRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AirportServiceImpl service class.
 * Implements AirportService interface.
 */
@Service
public class AirportServiceImpl implements AirportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirportServiceImpl.class);

    @Autowired
    private AirportRepo airportRepo;

    /**
     * {@inheritDoc}
     * {@link com.project.service.AirportService#retrieveAirportInformation(java.lang.Long)}.
     */
    @Override
    public Airport retrieveAirportInformation(final Long id) {
        final Optional<Airport> retrievedAirport = this.airportRepo.findById(id);

        if(retrievedAirport.isPresent()) {
            return retrievedAirport.get();
        } else {
            LOGGER.error("No airport found with given id '" + id + "'!");
            throw new NoSuchElementException("Searched airport not found!");
        }
    }

}

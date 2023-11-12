package com.project.service;

import java.util.List;

import com.project.model.basemodel.Airline;
import org.springframework.stereotype.Service;

/**
 * AirlineService service interface.
 */
@Service
public interface AirlineService {

    /**
     * Retrieves all airlines.
     *
     * @return  a list of all found airlines
     */
    List<Airline> retrieveAllAirlines();

}

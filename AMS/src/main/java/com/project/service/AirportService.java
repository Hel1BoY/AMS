package com.project.service;

import com.project.model.basemodel.Airport;
import org.springframework.stereotype.Service;

/**
 * AirportService service interface.
 */
@Service
public interface AirportService {

    /**
     * Retrieves airport information by given id.
     *
     * @param id
     *          the id
     * @return  the found airport
     */
    Airport retrieveAirportInformation(Long id);

}

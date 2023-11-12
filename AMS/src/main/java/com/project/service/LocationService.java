package com.project.service;

import java.util.List;

import com.project.model.basemodel.Location;
import org.springframework.stereotype.Service;

/**
 * LocationService service interface.
 */
@Service
public interface LocationService {

    /**
     * Retrieves all locations.
     *
     * @return  a list of all found locations
     */
    List<Location> retrieveAllLocations();

    /**
     * Retrieves locations by country name.
     *
     * @param countryName
     *          the country name
     * @return  a list of all found locations
     */
    List<Location> retrieveLocationsByCountryName(String countryName);

}

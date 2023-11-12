package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.model.basemodel.Location;
import com.project.repository.LocationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LocationServiceImpl service class.
 * Implements LocationService interface.
 */
@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationRepo locationRepo;

    /**
     * {@inheritDoc}
     * {@link com.project.service.LocationService#retrieveAllLocations()}.
     */
    @Override
    public List<Location> retrieveAllLocations() {
        final Optional<List<Location>> retrievedLocations = Optional.ofNullable(this.locationRepo.findAll());

        if(retrievedLocations.isPresent()) {
            return retrievedLocations.get();
        } else {
            LOGGER.error("No locations found!");
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.LocationService#retrieveLocationsByCountryName(java.lang.String)}.
     */
    @Override
    public List<Location> retrieveLocationsByCountryName(final String countryName) {
        final Optional<List<Location>> retrievedLocations = Optional.ofNullable(this.locationRepo.findAllByCountryName(countryName));

        if(retrievedLocations.isPresent()) {
            return retrievedLocations.get();
        } else {
            LOGGER.error("No locations found!");
            return new ArrayList<>();
        }
    }

}

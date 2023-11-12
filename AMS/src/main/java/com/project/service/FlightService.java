package com.project.service;

import java.util.List;

import com.project.model.basemodel.Flight;
import org.springframework.stereotype.Service;

/**
 * FlightService service interface.
 */
@Service
public interface FlightService {

    /**
     * Retrieves all present arrival flights.
     *
     * @return  a list of found flights
     */
    List<Flight> retrieveAllPresentArrivalFlights();

    /**
     * Retrieves all present arrival flights by country name.
     *
     * @return  a list of found flights
     */
    List<Flight> retrieveAllPresentArrivalFlightsByCountry(String countryName);

    /**
     * Retrieves all present departing flights.
     *
     * @return  a list of found flights
     */
    List<Flight> retrieveAllPresentDepartingFlights();

    /**
     * Retrieves all present departing flights by country name.
     *
     * @return  a list of found flights
     */
    List<Flight> retrieveAllPresentDepartingFlightsByCountry(String countryName);

    /**
     * Retrieves all present waiting flights.
     *
     * @return  a list of found flights
     */
    List<Flight> retrieveAllPresentWaitingFlights();

    /**
     * Retrieves all present waiting flights by country name.
     *
     * @return  a list of found flights
     */
    List<Flight> retrieveAllPresentWaitingFlightsByCountry(String countryName);

    /**
     * Retrieves all present canceled flights.
     *
     * @return  a list of found flights
     */
    public List<Flight> retrieveAllPresentCanceledFlights();

    /**
     * Retrieves all present canceled flights by country name.
     *
     * @return  a list of found flights
     */
    public List<Flight> retrieveAllPresentCanceledFlightsByCountry(final String countryName);

}

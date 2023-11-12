package com.project.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.project.model.basemodel.Flight;
import com.project.repository.FlightRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FlightServiceImpl service class.
 * Implements FlightService interface.
 */
@Service
public class FlightServiceImpl implements FlightService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private FlightRepo flightRepo;

    /**
     * {@inheritDoc}
     * {@link com.project.service.FlightService#retrieveAllPresentArrivalFlights()}.
     */
    @Override
    public List<Flight> retrieveAllPresentArrivalFlights() {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Calendar cal = Calendar.getInstance();
        final String dateToday = dateFormat.format(cal.getTime());

        final Optional<List<Flight>> retrievedFlights = Optional.ofNullable(this.flightRepo
                .findAllArrivalFlightsByDate(dateToday));

        if(retrievedFlights.isPresent()) {
            return retrievedFlights.get();
        } else {
            LOGGER.error("No flights found!");
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.FlightService#retrieveAllPresentArrivalFlightsByCountry(java.lang.String)}.
     */
    @Override
    public List<Flight> retrieveAllPresentArrivalFlightsByCountry(final String countryName) {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Calendar cal = Calendar.getInstance();
        final String dateToday = dateFormat.format(cal.getTime());

        final Optional<List<Flight>> retrievedFlights = Optional.ofNullable(this.flightRepo
                .findAllArrivalsByCountryAndArrivalDate(dateToday, countryName.toUpperCase()));

        if(retrievedFlights.isPresent()) {
            return retrievedFlights.get();
        } else {
            LOGGER.error("No flights found!");
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.FlightService#retrieveAllPresentDepartingFlights()}.
     */
    @Override
    public List<Flight> retrieveAllPresentDepartingFlights() {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Calendar cal = Calendar.getInstance();
        final String dateToday = dateFormat.format(cal.getTime());

        final Optional<List<Flight>> retrievedFlights = Optional.ofNullable(this.flightRepo
                .findAllDepartingsByDate(dateToday));

        if(retrievedFlights.isPresent()) {
            return retrievedFlights.get();
        } else {
            LOGGER.error("No flights found!");
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.FlightService#retrieveAllPresentDepartingFlightsByCountry(java.lang.String)}.
     */
    @Override
    public List<Flight> retrieveAllPresentDepartingFlightsByCountry(final String countryName) {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Calendar cal = Calendar.getInstance();
        final String dateToday = dateFormat.format(cal.getTime());

        final Optional<List<Flight>> retrievedFlights = Optional.ofNullable(this.flightRepo
                .findAllDepartingsByCountryAndArrivalTime(dateToday, countryName.toUpperCase()));

        if(retrievedFlights.isPresent()) {
            return retrievedFlights.get();
        } else {
            LOGGER.error("No flights found!");
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.FlightService#retrieveAllPresentWaitingFlights()}.
     */
    @Override
    public List<Flight> retrieveAllPresentWaitingFlights() {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Calendar cal = Calendar.getInstance();
        final String dateToday = dateFormat.format(cal.getTime());

        final Optional<List<Flight>> retrievedFlights = Optional.ofNullable(this.flightRepo
                .findAllWaitingsByDate(dateToday));

        if(retrievedFlights.isPresent()) {
            return retrievedFlights.get();
        } else {
            LOGGER.error("No flights found!");
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.FlightService#retrieveAllPresentWaitingFlightsByCountry(java.lang.String)}.
     */
    @Override
    public List<Flight> retrieveAllPresentWaitingFlightsByCountry(final String countryName) {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Calendar cal = Calendar.getInstance();
        final String dateToday = dateFormat.format(cal.getTime());

        final Optional<List<Flight>> retrievedFlights = Optional.ofNullable(this.flightRepo
                .findAllWaitingsByCountryAndArrivalTime(dateToday, countryName.toUpperCase()));

        if(retrievedFlights.isPresent()) {
            return retrievedFlights.get();
        } else {
            LOGGER.error("No flights found!");
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.FlightService#retrieveAllPresentCanceledFlights()}.
     */
    @Override
    public List<Flight> retrieveAllPresentCanceledFlights() {
        final Optional<List<Flight>> retrievedFlights = Optional.ofNullable(this.flightRepo
                .findAllCanceledFlights());

        if(retrievedFlights.isPresent()) {
            return retrievedFlights.get();
        } else {
            LOGGER.error("No flights found!");
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.FlightService#retrieveAllPresentCanceledFlightsByCountry(java.lang.String)}.
     */
    @Override
    public List<Flight> retrieveAllPresentCanceledFlightsByCountry(final String countryName) {
        final Optional<List<Flight>> retrievedFlights = Optional.ofNullable(this.flightRepo
                .findAllCanceledFlightsByCountryAndArrivalTime(countryName.toUpperCase()));

        if(retrievedFlights.isPresent()) {
            return retrievedFlights.get();
        } else {
            LOGGER.error("No flights found!");
            return new ArrayList<>();
        }
    }

}

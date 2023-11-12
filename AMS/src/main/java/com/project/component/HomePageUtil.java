package com.project.component;

import java.util.List;

import com.project.model.basemodel.Flight;
import com.project.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * HomePageUtil class.
 * HomePageControllerImpl class helper.
 */
@Component("HomePageUtil")
public class HomePageUtil {

    @Autowired
    private FlightService flightService;

    /**
     * Retrieves all present arrival flights.
     *
     * @param countryName
     *          the country name search parameter
     * @return  a list of all found flights
     */
    public List<String> retrieveAllPresentArrivalFlights(final String countryName) {
        final String countryNameWithNoSpaces = countryName.replaceAll("\\s", "");
        final List<Flight> retrievedFlights = flightService.retrieveAllPresentArrivalFlightsByCountry(countryNameWithNoSpaces);
        final List<String> formattedData = retrievedFlights.stream().map(Flight::toStringFormatted).toList();

        return formattedData;
    }

    /**
     * ...
     *
     * @param countryName
     * @return
     */
    public List<Flight> retrieveAllPresentDepartingFlights(final String countryName) {
        // waiting for implementation
        return null;
    }

    /**
     * ...
     *
     * @param countryName
     * @return
     */
    public List<Flight> retrieveAllPresentWaitingFlights(final String countryName) {
        // waiting for implementation
        return null;
    }

    /**
     * ...
     *
     * @param countryName
     * @return
     */
    public List<Flight> retrieveAllPresentCanceledFlights(final String countryName) {
        // waiting for implementation
        return null;
    }

}

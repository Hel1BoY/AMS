package com.project.repository;

import java.util.List;

import com.project.model.basemodel.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * FlightRepo repository.
 */
@Repository
public interface FlightRepo extends CrudRepository<Flight, Long> {

    /**
     * Finds all arrival flights by date.
     *
     * @param givenDate
     *          the date
     * @return  the found flights
     */
    @Query(value = "SELECT * FROM FLIGHTS " + //
            "WHERE (FLIGHTS.ARRIVED_AT LIKE CONCAT('%', :givenDate, '%') OR FLIGHTS.ARRIVED_AT IS NULL) " + //
            "AND STATUS = 'ARRIVED';" ,//
            nativeQuery = true)
    List<Flight> findAllArrivalFlightsByDate(@Param("givenDate") String givenDate);

    /**
     * Finds all arrival flight records by country name and date from database.
     *
     * @param givenDate
     *          the date
     * @param countryName
     *          the country name
     * @return  a list of all found records
     */
    @Query(value = "SELECT * FROM FLIGHTS WHERE FLIGHTS.ID IN " + //
            "(" + //
            " SELECT FLIGHTS.ID FROM FLIGHTS, LOCATION, COUNTRY " + //
            " WHERE FLIGHTS.FROM_LOCATION = LOCATION.ID AND LOCATION.COUNTRY_ID = COUNTRY.ID AND UPPER(COUNTRY.NAME)=:countryName AND " + //
            " (FLIGHTS.ARRIVED_AT LIKE CONCAT('%', :givenDate, '%') OR FLIGHTS.ARRIVED_AT IS NULL) " + //
            " AND STATUS = 'ARRIVED'" + //
            ");" ,//
            nativeQuery = true)
    List<Flight> findAllArrivalsByCountryAndArrivalDate(@Param("givenDate") String givenDate, @Param("countryName") String countryName);

    /**
     * Finds all departing flight records by date from database.
     *
     * @param givenDate
     *          the date
     * @return  a list of all found records
     */
    @Query(value = "SELECT * FROM FLIGHTS WHERE FLIGHTS.ID IN " + //
            "(" + //
            "SELECT FLIGHTS.ID FROM FLIGHTS " + //
            "WHERE FLIGHTS.DEPARTING_AT LIKE CONCAT('%', :givenDate, '%') " + //
            "AND STATUS = 'DEPARTED'" + //
            ");",
            nativeQuery = true)
    List<Flight> findAllDepartingsByDate(@Param("givenDate") String givenDate);

    /**
     * Finds all departing flight records by country name and date from database.
     *
     * @param givenDate
     *          the date
     * @param countryName
     *          the country name
     * @return  a list of all found records
     */
    @Query(value = "SELECT * FROM FLIGHTS WHERE FLIGHTS.ID IN " + //
            "(" + //
            "SELECT FLIGHTS.ID FROM FLIGHTS, LOCATION, COUNTRY " + //
            "WHERE FLIGHTS.TO_LOCATION = LOCATION.ID AND LOCATION.COUNTRY_ID = COUNTRY.ID AND UPPER(COUNTRY.NAME)=:countryName AND " + //
            "FLIGHTS.DEPARTING_AT LIKE CONCAT('%', :givenDate, '%') " + //
            "AND STATUS = 'DEPARTED'" + //
            ");" ,//
            nativeQuery = true)
    List<Flight> findAllDepartingsByCountryAndArrivalTime(@Param("givenDate") String givenDate, @Param("countryName") String countryName);

    /**
     * Finds all waiting flight records by date from database.
     *
     * @param givenDate
     *          the date
     * @return  a list of all found records
     */
    @Query(value = "SELECT * FROM FLIGHTS " + //
            "WHERE FLIGHTS.DEPARTING_AT LIKE CONCAT('%', :givenDate, '%') " + //
            "AND STATUS = 'WAITING';" ,//
            nativeQuery = true)
    List<Flight> findAllWaitingsByDate(@Param("givenDate") String givenDate);

    /**
     * Finds all waiting flight records by country name and date from database.
     *
     * @param givenDate
     *          the date
     * @param countryName
     *          the country name
     * @return  a list of all found records
     */
    @Query(value = "SELECT * FROM FLIGHTS WHERE FLIGHTS.ID IN " + //
            "(" + //
            "SELECT FLIGHTS.ID FROM FLIGHTS, LOCATION, COUNTRY " + //
            "WHERE FLIGHTS.TO_LOCATION = LOCATION.ID AND LOCATION.COUNTRY_ID = COUNTRY.ID AND UPPER(COUNTRY.NAME)=:countryName AND " + //
            "FLIGHTS.DEPARTING_AT LIKE CONCAT('%', :givenDate, '%') " + //
            "AND STATUS = 'WAITING'" + //
            ");",
            nativeQuery = true)
    List<Flight> findAllWaitingsByCountryAndArrivalTime(@Param("givenDate") String givenDate, @Param("countryName") String countryName);

    /**
     * Finds all canceled flight records from database.
     *
     * @return  a list of all found records
     */
    @Query(value = "SELECT * FROM FLIGHTS " + //
            "WHERE FLIGHTS.DEPARTING_AT IS NULL " + //
            "AND STATUS = 'CANCELED';" ,//
            nativeQuery = true)
    List<Flight> findAllCanceledFlights();

    /**
     * Finds all canceled flight records by country name from database.
     *
     * @param countryName
     *          the country name
     * @return  a list of all found records
     */
    @Query(value = "SELECT * FROM FLIGHTS WHERE FLIGHTS.ID IN " + //
            "(" + //
            "SELECT FLIGHTS.ID FROM FLIGHTS, LOCATION, COUNTRY " + //
            "WHERE FLIGHTS.TO_LOCATION = LOCATION.ID AND LOCATION.COUNTRY_ID = COUNTRY.ID AND UPPER(COUNTRY.NAME)=:countryName AND " + //
            "FLIGHTS.DEPARTING_AT IS NULL " + //
            "AND STATUS = 'CANCELED'" + //
            ");" ,//
            nativeQuery = true)
    List<Flight> findAllCanceledFlightsByCountryAndArrivalTime(@Param("countryName") String countryName);

}

package com.project.repository;

import java.util.List;

import com.project.model.basemodel.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * AirlineRepo repository.
 */
@Repository
public interface AirlineRepo extends CrudRepository<Airline, Long> {

    /**
     * Saves or updates an airline in database.
     *
     * @param airline
     *              the airline
     * @return  the airline
     */
    Airline save(Airline airline);

    /**
     * Retrieves all airlines records in database.
     *
     * @return  a list of all found records
     */
    List<Airline> findAll();

}

package com.project.repository;

import java.util.Optional;

import com.project.model.basemodel.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * AirportRepo repository.
 */
@Repository
public interface AirportRepo extends CrudRepository<Airport, Long> {

    /**
     * Finds airport record by given id from database.
     *
     * @param id
     *          the id
     * @return  an optional of the airport record
     */
    Optional<Airport> findById(Long id);

}

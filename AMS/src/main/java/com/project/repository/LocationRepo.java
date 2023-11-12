package com.project.repository;

import java.util.List;

import com.project.model.basemodel.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * LocationRepo repository.
 */
@Repository
public interface LocationRepo extends CrudRepository<Location, Long> {

    /**
     * Finds all location records from database.
     *
     * @return  a list of all found location records
     */
    List<Location> findAll();

    /**
     * Finds all location records by given country id from database.
     *
     * @param countryId
     *          the country id
     * @return  a list of all found location records
     */
    List<Location> findAllByCountryId(Long countryId);

    /**
     * Finds all location records by given city from database.
     *
     * @param city
     *          the city
     * @return  a list of all found location records
     */
    List<Location> findAllByCity(String city);

    /**
     * Finds all location records
     *
     * @param countryName
     *          the country name
     * @return  a list of all found location records
     */
    List<Location> findAllByCountryName(String countryName);

}

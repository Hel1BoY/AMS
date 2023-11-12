package com.project.repository;

import java.util.List;

import com.project.model.basemodel.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CountryRepo repository.
 */
@Repository
public interface CountryRepo extends CrudRepository<Country, Long> {

    /**
     * Retrieves all country records from database.
     *
     * @return  a list of all found countries
     */
    List<Country> findAll();

    /**
     * Finds a country record by given name from database.
     *
     * @param name
     *          the name
     * @return  the found country
     */
    Country findByName(String name);

    /**
     * Finds country record by given code from database.
     *
     * @param code
     *          the code
     * @return  the found country
     */
    Country findByCode(String code);

}

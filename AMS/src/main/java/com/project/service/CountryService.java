package com.project.service;

import java.util.List;

import com.project.model.basemodel.Country;
import org.springframework.stereotype.Service;

/**
 * CountryService service interface.
 */
@Service
public interface CountryService {

    /**
     * Retrieves all destination countries.
     *
     * @return  a list of all destinations
     */
    List<Country> retrieveAllDestinationCountries();

    /**
     * Gets country by given name.
     *
     * @param name
     *          the name
     * @return  the found country
     */
    Country getCountryByName(String name);

    /**
     * Gets country by given code.
     *
     * @param code
     *          the code
     * @return  the found country
     */
    Country getCountryByCode(String code);

}

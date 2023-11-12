package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.model.basemodel.Country;
import com.project.repository.CountryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CountryServiceImpl service class.
 * Implements CountryService interface.
 */
@Service
public class CountryServiceImpl implements CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private CountryRepo countryRepo;

    /**
     * {@inheritDoc}
     * {@link com.project.service.CountryService#retrieveAllDestinationCountries()}.
     */
    @Override
    public List<Country> retrieveAllDestinationCountries() {
        final Optional<List<Country>> retrievedCountries = Optional.ofNullable(this.countryRepo.findAll());

        if(retrievedCountries.isPresent()) {
            return retrievedCountries.get();
        } else {
            LOGGER.error("No countries found!");
            return new ArrayList<>();
        }

    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.CountryService#getCountryByName(java.lang.String)}.
     */
    @Override
    public Country getCountryByName(final String name) {
        final Optional<Country> retrievedCountry = Optional.ofNullable(this.countryRepo.findByName(name));

        if(retrievedCountry.isPresent()) {
            return retrievedCountry.get();
        } else {
            LOGGER.info("No country found!");
            return new Country();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.CountryService#getCountryByCode(java.lang.String)}.
     */
    @Override
    public Country getCountryByCode(final String code) {
        final Optional<Country> retrievedCountry = Optional.ofNullable(this.countryRepo.findByCode(code));

        if(retrievedCountry.isPresent()) {
            return retrievedCountry.get();
        } else {
            LOGGER.warn("No countries found!");
            return new Country();
        }
    }

}

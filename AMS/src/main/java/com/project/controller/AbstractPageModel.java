package com.project.controller;

import com.project.model.basemodel.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

/**
 * AbstractPageModel abstract class.
 * Used to collect basic data for pages navigation bar
 */
public abstract class AbstractPageModel {

    /** Constant for ... */
    public static final String AIRPORT_NAME_MODEL_KEY = "airportName";

    /** Constant for ... */
    public static final String WEATHER_MODEL_KEY = "weather";

    @Value("${airportName}")
    private String airportName;

    /** from configuration */
    @Autowired
    private WeatherDto weather;

    /**
     * Gets the weather data.
     *
     * @return  the weather data
     */
    protected WeatherDto getWeather() {
        return weather;
    }

    /**
     * Gets the airport name.
     *
     * @return  the airport name.
     */
    protected String getAirportName() {
        return this.airportName;
    }

    /**
     * Initialize navigation bar information.
     *
     * @param model
     *          the model to save data
     */
    protected void initEssentialNavigationBarInfo(final Model model) {
        model.addAttribute(AIRPORT_NAME_MODEL_KEY, this.airportName);
        model.addAttribute(WEATHER_MODEL_KEY, this.weather);
    }

}

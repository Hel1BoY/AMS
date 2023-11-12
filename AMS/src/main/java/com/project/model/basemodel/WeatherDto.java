package com.project.model.basemodel;

/**
 * WeatherDto class.
 */
public class WeatherDto {

    /** The temperature in Celsius. */
    private Float temperature;

    private String city;

    private String type;

    /**
     * Constructor.
     *
     * @param temperature
     *          the temperature
     * @param city
     *          the city
     * @param type
     *          the temperature type
     */
    public WeatherDto(final Float temperature, final String city, final String type) {
        this.temperature = temperature;
        this.city = city;
        this.type = type;
    }

    /**
     * Gets the temperature.
     *
     * @return the temperature
     */
    public Float getTemperature() {
        return this.temperature;
    }

    /**
     * Sets the temperature.
     *
     * @param temperature
     *          the temperature
     */
    public void setTemperature(final Float temperature) {
        this.temperature = temperature;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city.
     *
     * @param city
     *          the city
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type.
     *
     * @param type
     *          the type
     */
    public void setType(final String type) {
        this.type = type;
    }

}

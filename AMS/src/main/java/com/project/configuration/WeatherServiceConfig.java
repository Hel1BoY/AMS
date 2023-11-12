package com.project.configuration;

import java.util.NoSuchElementException;

//import com.project.model.pagemodel.AbstractPageModel;
import com.project.model.basemodel.WeatherDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * WeatherServiceConfig class.
 * Used for retrieving weather data.
 *
 * (Waiting for more implementation)
 */
@Configuration
//@ComponentScan(basePackageClasses = {AbstractPageModel.class})
public class WeatherServiceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceConfig.class);

    @Value("${city}")
    private String city;

    /**
     * Used to retrieve weather data.
     *
     * @return  a mocked data ...
     */
    @Bean
    public WeatherDto getWeatherLocally() {

        try {
            final WeatherDto weather = new WeatherDto(20F, this.city, "sunny");
            return weather;

        } catch (NoSuchElementException e) {
            LOGGER.warn("The service failed -> ", e);
        }

        return new WeatherDto(0F, "", "");
    }

}

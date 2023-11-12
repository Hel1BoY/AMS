package com.project.controller;

import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.TreeMap;
import java.util.ArrayList;

import com.project.enums.Pages;
import com.project.model.basemodel.Location;
import com.project.service.LocationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * DestinationControllerImpl controller class.
 * Extends AbstractPageModel abstract class. Implements DestinationController interface.
 *
 * Loads destinations page.
 */
@Controller
@RequestMapping("/destinations")
public class DestinationControllerImpl extends AbstractPageModel implements DestinationController {

    @Autowired
    private LocationService locationService;

    /**
     * {@inheritDoc}
     * {@link com.project.controller.DestinationController#showAllDestinations(jakarta.servlet.http.HttpServletRequest, org.springframework.ui.Model)}.
     */
    @Override
    @RequestMapping
    public ModelAndView showAllDestinations(final HttpServletRequest request, final Model model) {
        final List<Location> destinations = this.locationService.retrieveAllLocations();
        final Map<String, List<String>> sortedDestinations = new TreeMap<>();

        for(final Location location : destinations) {
            final String countryName = location.getCountry().getName();
            final String city = location.getCity();
            final String skipCity = "Sofia";

            if(city.equals(skipCity)) {
                continue;
            }

            if(sortedDestinations.containsKey(countryName)) {
                sortedDestinations.get(countryName).add(city);
            } else {
                sortedDestinations.put(countryName, new ArrayList<>(Collections.singletonList(city)));
            }
        }

        super.initEssentialNavigationBarInfo(model);
        model.addAttribute("destinations", sortedDestinations);

        return new ModelAndView(Pages.DESTINATIONS_PAGE.getPage());
    }

}

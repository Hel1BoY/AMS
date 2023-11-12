package com.project.controller;

import java.util.List;

import com.project.model.basemodel.Flight;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomePageController interface.
 */
@Controller
@RequestMapping("/home")
public interface HomePageController {

    /**
     * Loads home page data.
     *
     * @param request
     *          the request
     * @param model
     *          the model to save data
     * @return  the model and view page
     */
    @RequestMapping
    ModelAndView loadPageData(HttpServletRequest request, Model model);

    /**
     * Retrieves all present arrival flights.
     * (Used for ajax calls)
     *
     * @param countryName
     *              the country name search parameter
     * @return  a list of found flights
     */
    @RequestMapping(value="/request/getPresentArrivalFlights", method=RequestMethod.GET)
    @ResponseBody List<String> retrieveAllPresentArrivalFlights(@RequestParam(value = "countryName") final String countryName);

    /**
     * Retrieves all present waiting flights.
     *
     * @return  a list of found flights
     */
    @RequestMapping(value="/g", method=RequestMethod.GET)
    @ResponseBody List<Flight> retrieveAllPresentWaitingFlights();

    /**
     * Retrieves all present departing flights.
     *
     * @return  a list of found flights
     */
    @RequestMapping(value="/ge", method=RequestMethod.GET)
    @ResponseBody List<Flight> retrieveAllPresentDepartingFlights();

    /**
     * Retrieves all present canceled flights.
     *
     * @return  a list of found flights
     */
    @RequestMapping(value="/get", method=RequestMethod.GET)
    @ResponseBody List<Flight> retrieveAllPresentCanceledFlights();

}
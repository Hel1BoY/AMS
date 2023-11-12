package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.component.HomePageUtil;
import com.project.enums.FlightStatus;
import com.project.enums.Pages;
import com.project.model.basemodel.Flight;
import com.project.service.FlightService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomePageControllerImpl controller class.
 * Extends AbstractPageModel abstract class. Implements HomePageController.
 *
 * Loads home page.
 */
@Controller
@RequestMapping("/home")
public class HomePageControllerImpl extends AbstractPageModel implements HomePageController {

    @Autowired
    private HomePageUtil homePageUtil;

    @Autowired
    private FlightService flightService;

    /**
     * {@inheritDoc}
     * {@link com.project.controller.HomePageController#loadPageData(jakarta.servlet.http.HttpServletRequest, org.springframework.ui.Model)}.
     */
    @Override
    @RequestMapping
    public ModelAndView loadPageData(final HttpServletRequest request, final Model model) {
        final Map<String, List<Flight>> categorizedFlights = new HashMap<>();
        final List<Flight> allPresentArrivalFlights = this.flightService.retrieveAllPresentArrivalFlights();
        final List<Flight> allPresentWaitingFlights = this.flightService.retrieveAllPresentWaitingFlights();
        final List<Flight> allPresentDepartingFlights = this.flightService.retrieveAllPresentDepartingFlights();

        categorizedFlights.put(FlightStatus.ARRIVED.name(), allPresentArrivalFlights);
        categorizedFlights.put(FlightStatus.WAITING.name(), allPresentWaitingFlights);
        categorizedFlights.put(FlightStatus.DEPARTED.name(), allPresentDepartingFlights);

        super.initEssentialNavigationBarInfo(model);
        model.addAttribute("categorizedFlights", categorizedFlights);
        return new ModelAndView(Pages.HOME_PAGE.getPage());
    }

    /**
     * {@inheritDoc}
     * {@link com.project.controller.HomePageController#retrieveAllPresentArrivalFlights(java.lang.String)}.
     */
    @Override
    @RequestMapping(value="/request/getPresentArrivalFlights", method=RequestMethod.GET)
    public @ResponseBody List<String> retrieveAllPresentArrivalFlights(@RequestParam(value = "countryName") final String countryName) {
        return this.homePageUtil.retrieveAllPresentArrivalFlights(countryName);
    }

    /**
     * ...
     *
     * @return ...
     */
    @Override
    @RequestMapping(value="/g", method=RequestMethod.GET)
    public List<Flight> retrieveAllPresentWaitingFlights() {
        // waiting for implementation
        return null;
    }

    /**
     * ...
     *
     * @return ...
     */
    @Override
    @RequestMapping(value="/ge", method=RequestMethod.GET)
    public List<Flight> retrieveAllPresentDepartingFlights() {
        // waiting for implementation
        return null;
    }

    /**
     * ...
     *
     * @return ...
     */
    @Override
    @RequestMapping(value="/get", method=RequestMethod.GET)
    public List<Flight> retrieveAllPresentCanceledFlights() {
        // waiting for implementation
        return null;
    }

}

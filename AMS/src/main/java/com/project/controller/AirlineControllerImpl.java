package com.project.controller;

import java.util.List;

import com.project.enums.Pages;
import com.project.model.basemodel.Airline;
import com.project.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * AirlineControllerImpl controller class.
 * Extends AbstractPageModel abstract class. Implements AirlineController interface.
 *
 * Loads airlines page.
 */
@Controller
@RequestMapping("/airlines")
public class AirlineControllerImpl extends AbstractPageModel implements AirlineController {

    @Autowired
    private AirlineService airlineService;

    /**
     * {@inheritDoc}
     * {@link com.project.controller.AirlineController#showAllAirlines(org.springframework.ui.Model)}.
     */
    @Override
    @RequestMapping
    public ModelAndView showAllAirlines(final Model model) {
        final List<Airline> retrievedAirlines = this.airlineService.retrieveAllAirlines();

        super.initEssentialNavigationBarInfo(model);
        model.addAttribute("airlines", retrievedAirlines);

        return new ModelAndView(Pages.AIRLINES_PAGE.getPage());
    }

}

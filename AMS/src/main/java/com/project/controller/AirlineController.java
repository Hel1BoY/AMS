package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

/**
 * AirlineController interface.
 */
@Controller
@RequestMapping("/airlines")
public interface AirlineController {

    /**
     * Shows all airlines.
     *
     * @param model
     *          the model to save data
     * @return  the model and view page
     */
    ModelAndView showAllAirlines(Model model);

}

package com.project.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * DestinationController interface.
 */
@Controller
@RequestMapping("/destinations")
public interface DestinationController {

    /**
     * Shows all available destinations.
     *
     * @param request
     *          the request
     * @param model
     *          the model to save data
     * @return  the model and view page
     */
    @RequestMapping
    ModelAndView showAllDestinations(HttpServletRequest request, Model model);

}

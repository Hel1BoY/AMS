package com.project.controller;

import com.project.model.basemodel.JobPosition;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/careers")
public interface CareersController {

    /**
     * Retrieves all open job positions.
     *
     * @param request
     *          the request
     * @param model
     *          the model to save data
     * @return  the model and view page
     */
    @GetMapping
    ModelAndView retrieveAllOpenJobPositions(HttpServletRequest request, Model model);

    /**
     * Saves new job position.
     *
     * @param jobPosition
     *          the job position
     * @param contactId
     *          the job position contact id
     * @param model
     *          the model
     * @param response
     *          the response
     * @return  the model and view
     *
     * @throws IOException
     *          the exception
     */
    @PostMapping("/saveNewPosition/{contactId}")
    ModelAndView saveNewJobPosition(@ModelAttribute("newJobPosition") JobPosition jobPosition,
                                    @PathVariable(name="contactId") String contactId, Model model,
                                    HttpServletResponse response) throws IOException;

    /**
     * Edits an existing job position.
     *
     * @param updatedJobPosition
     *          the updated job position
     * @param jobPositionId
     *          the existing job position id
     * @param contactId
     *          the updated job position contact id
     * @param model
     *          the model
     * @param response
     *          the response
     * @return  the model and view
     *
     * @throws IOException
     *          the exception
     */
    @PostMapping("/editPosition")
    ModelAndView editJobPosition(@ModelAttribute("newJobPosition") JobPosition updatedJobPosition,
                                        @RequestParam(value="jobPositionId") String jobPositionId,
                                        @RequestParam(value="contactId") String contactId,
                                        Model model, HttpServletResponse response) throws IOException;

    /**
     * Closes an existing job position.
     *
     * @param positionId
     *          the job position id for closing
     * @param model
     *          the model
     * @param response
     *          the response
     * @return  the model and view
     *
     * @throws IOException
     *          the exception
     */
    @PostMapping("/closePosition/{id}")
    ModelAndView closeJobPosition(@PathVariable(name = "id") String positionId, Model model,
                                  HttpServletResponse response) throws IOException;
}

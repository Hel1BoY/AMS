package com.project.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.project.enums.Pages;
import com.project.enums.WorkingHours;
import com.project.model.basemodel.Contact;
import com.project.model.basemodel.JobPosition;
import com.project.service.ContactService;
import com.project.service.JobPositionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * CareersControllerImpl controller class.
 * Extends AbstractPageModel abstract class. Implements CareersController interface.
 *
 * Loads careers page.
 */
@Controller
@RequestMapping("/careers")
public class CareersControllerImpl extends AbstractPageModel implements CareersController {

    private static final String DEFAULT_URL = "http://localhost:8080/careers";

    private static final Logger LOGGER = LoggerFactory.getLogger(CareersControllerImpl.class);

    @Autowired
    private JobPositionService jobPositionService;

    @Autowired
    private ContactService contactService;

    /**
     * {@inheritDoc}
     * {@link com.project.controller.CareersController#retrieveAllOpenJobPositions(jakarta.servlet.http.HttpServletRequest, org.springframework.ui.Model)}.
     */
    @Override
    @RequestMapping
    public ModelAndView retrieveAllOpenJobPositions(final HttpServletRequest request, final Model model) {
        retrievePageEssentialData(model);
        return new ModelAndView(Pages.CAREERS_PAGE.getPage());
    }

    /**
     * {@inheritDoc}
     * {@link com.project.controller.CareersController#saveNewJobPosition(com.project.model.basemodel.JobPosition, java.lang.String, org.springframework.ui.Model, jakarta.servlet.http.HttpServletResponse)}.
     */
    @Override
    @PostMapping("/saveNewPosition/{contactId}")
    public ModelAndView saveNewJobPosition(@ModelAttribute("newJobPosition") final JobPosition updatedjobPosition,
                   @PathVariable(name="contactId") final String contactId, final Model model, final HttpServletResponse response) throws IOException {
        this.jobPositionService.saveNewJobPosition(updatedjobPosition, Long.parseLong(contactId));

        retrievePageEssentialData(model);
        response.sendRedirect(DEFAULT_URL);
        return new ModelAndView(Pages.CAREERS_PAGE.getPage());
    }

    /**
     * {@inheritDoc}
     * {@link com.project.controller.CareersController#editJobPosition(com.project.model.basemodel.JobPosition, java.lang.String, java.lang.String, org.springframework.ui.Model, jakarta.servlet.http.HttpServletResponse)}.
     */
    @Override
    @PostMapping("/editPosition")
    public ModelAndView editJobPosition(@ModelAttribute("updatedJobPosition") final JobPosition jobPosition,
                                        @RequestParam(value="jobPositionId") final String jobPositionId,
                                        @RequestParam(value="contactId") final String contactId,
                                        final Model model, final HttpServletResponse response) throws IOException {
        this.jobPositionService.editExistingJobPosition(jobPosition, Long.parseLong(jobPositionId),
                Long.parseLong(contactId));

        retrievePageEssentialData(model);
        response.sendRedirect(DEFAULT_URL);
        return new ModelAndView(Pages.CAREERS_PAGE.getPage());
    }

    /**
     * {@inheritDoc}
     * {@link com.project.controller.CareersController#closeJobPosition(java.lang.String, org.springframework.ui.Model, jakarta.servlet.http.HttpServletResponse)}.
     */
    @Override
    @PostMapping("/closePosition/{id}")
    public ModelAndView closeJobPosition(@PathVariable(name = "id") final String positionId, final Model model,
                                         final HttpServletResponse response) throws IOException {
        final JobPosition jobPosition = this.jobPositionService.closeJobPosition(Long.parseLong(positionId));
        retrievePageEssentialData(model);

        response.sendRedirect(DEFAULT_URL);
        return new ModelAndView(Pages.CAREERS_PAGE.getPage());
    }

    /**
     * Retrieves page essential data.
     *
     * @param model
     *          the model
     */
    private void retrievePageEssentialData(final Model model) {
        final List<JobPosition> openPositions = this.jobPositionService.retrieveAllOpenJobPositions();
        final List<Contact> allContacts = this.contactService.retrieveAllContacts();

        openPositions.forEach(pos -> pos.setPostedBefore(findDatesDifference(pos.getPublishingDate())));

        super.initEssentialNavigationBarInfo(model);
        model.addAttribute("openPositions", openPositions);
        model.addAttribute("allContacts", allContacts);
        model.addAttribute("workingHours", WorkingHours.values());
    }

    /**
     * Finds the difference from the job position publishing date till the current date.
     *
     * @param publishingDate
     *          the publishing date
     * @return an array of date and time units of the difference
     */
    private static long[] findDatesDifference(final LocalDateTime publishingDate) {
        final LocalDateTime dateNow = LocalDateTime.now();

        final long seconds = publishingDate.until(dateNow, ChronoUnit.SECONDS);
        final long minutes = publishingDate.until(dateNow, ChronoUnit.MINUTES);
        final long hours = publishingDate.until(dateNow, ChronoUnit.HOURS);
        final long days = publishingDate.until(dateNow, ChronoUnit.DAYS);
        final long weeks = publishingDate.until(dateNow, ChronoUnit.WEEKS);
        final long months = publishingDate.until(dateNow, ChronoUnit.MONTHS);

        return new long[]{months, weeks, days, hours, minutes, seconds};
    }

}

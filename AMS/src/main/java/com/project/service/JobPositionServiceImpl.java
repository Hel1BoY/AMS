package com.project.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.project.model.basemodel.Airport;
import com.project.model.basemodel.Contact;
import com.project.model.basemodel.JobPosition;
import com.project.repository.JobPositionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * JobPositionServiceImpl service class.
 * Implements JobPositionService interface.
 */
@Service
public class JobPositionServiceImpl implements JobPositionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private JobPositionRepo jobPositionRepo;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AirportService airportService;

    /**
     * {@inheritDoc}
     * {@link com.project.service.JobPositionService#retrieveAllOpenJobPositions()}.
     */
    @Override
    public List<JobPosition> retrieveAllOpenJobPositions() {
        final Optional<List<JobPosition>> openPositions = Optional.ofNullable(this.jobPositionRepo.findAllByStatusTrue());

        if(openPositions.isPresent()) {
            return openPositions.get();
        } else {
            LOGGER.warn("No job positions found!");
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.JobPositionService#saveNewJobPosition(com.project.model.basemodel.JobPosition, java.lang.Long)}.
     */
    @Override
    public JobPosition saveNewJobPosition(final JobPosition jobPosition, final Long contactId) {
        configureNewJobPosition(jobPosition, contactId);
        return this.jobPositionRepo.save(jobPosition);
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.JobPositionService#editExistingJobPosition(com.project.model.basemodel.JobPosition, java.lang.Long, java.lang.Long)}.
     */
    @Override
    public JobPosition editExistingJobPosition(final JobPosition updatedJobPosition, final Long jobPositionId,
                                               final Long contactId) {
        final Contact foundContact = this.contactService.retrieveContactById(contactId);
        final JobPosition retrievedJobPosition = retrieveJobPositionById(jobPositionId);

        updatedJobPosition.setContact(foundContact);
        updateJobPosition(retrievedJobPosition, updatedJobPosition);

        return this.jobPositionRepo.save(retrievedJobPosition);
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.JobPositionService#closeJobPosition(java.lang.Long)}.
     */
    @Override
    public JobPosition closeJobPosition(final Long id) {
        final List<JobPosition> foundJobPositions = this.retrieveAllOpenJobPositions();
        final JobPosition searchedPosition = foundJobPositions.stream().filter(pos -> pos.getId().equals(id)).findAny().get();

        searchedPosition.setStatus(Boolean.FALSE);
        searchedPosition.setClosingDate(LocalDateTime.now());

        return this.jobPositionRepo.save(searchedPosition);
    }

    /**
     * Configures new job position.
     *
     * @param jobPosition
     *          the job position
     * @param contactId
     *          the contact id
     */
    private void configureNewJobPosition(final JobPosition jobPosition, final Long contactId) {
        final Airport foundAirport = this.airportService.retrieveAirportInformation(1L);
        final Contact foundContact = this.contactService.retrieveContactById(contactId);

        jobPosition.setStatus(Boolean.TRUE);
        jobPosition.setPublishingDate(LocalDateTime.now());
        jobPosition.setContact(foundContact);
        jobPosition.setClosingDate(null);
        jobPosition.setAirport(foundAirport);
    }

    /**
     * Updates an existing job position.
     *
     * @param oldJobPosition
     *          the existing job position
     * @param updatedJobPosition
     *          the updated job position
     */
    private void updateJobPosition(final JobPosition oldJobPosition, final JobPosition updatedJobPosition) {
        oldJobPosition.setName(updatedJobPosition.getName());
        oldJobPosition.setWorkingHours(updatedJobPosition.getWorkingHours());
        oldJobPosition.setRequirements(updatedJobPosition.getRequirements());
        oldJobPosition.setContact(updatedJobPosition.getContact());
    }

    /**
     * Retrieves job position by id.
     *
     * @param id
     *          the id
     * @return  the retrieved job position
     */
    private JobPosition retrieveJobPositionById(final Long id) {
        final Optional<JobPosition> oldJobPosition = this.jobPositionRepo.findById(id);

        if(oldJobPosition.isPresent()) {
            return oldJobPosition.get();
        } else {
            LOGGER.error("No job position found with given id '" + id + "'!");
            throw new NoSuchElementException("Searched job position not found!");
        }
    }

}

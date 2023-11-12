package com.project.service;

import java.util.List;

import com.project.model.basemodel.JobPosition;
import org.springframework.stereotype.Service;

/**
 * JobPositionService service interface.
 */
@Service
public interface JobPositionService {

    /**
     * Retrieves all open job positions.
     *
     * @return  a list of all found positions
     */
    List<JobPosition> retrieveAllOpenJobPositions();

    /**
     * Saves newly created job position in database.
     *
     * @param jobPosition
     *          the job position
     * @return  the saved job position
     */
    JobPosition saveNewJobPosition(JobPosition jobPosition, Long contactId);

    /**
     * Edits an existing job position.
     *
     * @param updatedJobPosition
     *          the updated job position
     * @param jobPositionId
     *          the updated job position id
     * @param contactId
     *          the updated job position contact id
     * @return  the updated existing job position
     */
    JobPosition editExistingJobPosition(JobPosition updatedJobPosition, Long jobPositionId, Long contactId);

    /**
     * Closes an existing job position.
     *
     * @param id
     *          the job position id for closing
     * @return the closed job position
     */
    JobPosition closeJobPosition(Long id);

}

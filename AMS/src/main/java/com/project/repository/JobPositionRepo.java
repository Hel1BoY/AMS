package com.project.repository;

import java.util.List;

import com.project.model.basemodel.JobPosition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * JobPositionRepo repository.
 */
@Repository
public interface JobPositionRepo extends CrudRepository<JobPosition, Long> {

    /**
     * Saves or updates a job position in database.
     *
     * @param jobPosition
     *              the job position
     * @return  the job position
     */
    JobPosition save(JobPosition jobPosition);

    /**
     * Finds all job position records by given working hours from database.
     *
     * @param workingHours
     *              the working hours
     * @return  a list of all found job positions
     */
    List<JobPosition> findAllByWorkingHours(String workingHours);

    /**
     * Finds all open job positions records from database.
     *
     * @return  a list of all found job positions
     */
    List<JobPosition> findAllByStatusTrue();

    /**
     * Finds all job positions records by given name from database.
     *
     * @param name
     *          the name
     * @return  a list of all found job positions
     */
    List<JobPosition> findAllByName(String name);

    /**
     * Finds all job positions records from database.
     *
     * @return  a list of all found job positions
     */
    List<JobPosition> findAll();

}

package com.project.repository;

import java.util.List;
import java.util.Optional;

import com.project.model.basemodel.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ContactRepo repository.
 */
@Repository
public interface ContactRepo extends CrudRepository<Contact, Long> {

    /**
     * Retrieves all contacts records from database.
     *
     * @return  a list of all found records
     */
    List<Contact> findAll();

    /**
     * Finds a contact record by id from database.
     *
     * @param id
     *          the id
     * @return  the contact
     */
    Optional<Contact> findById(Long id);

}

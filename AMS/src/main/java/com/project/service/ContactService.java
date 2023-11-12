package com.project.service;

import java.util.List;

import com.project.model.basemodel.Contact;
import org.springframework.stereotype.Service;

/**
 * ContactService service interface.
 */
@Service
public interface ContactService {

    /**
     * Retrieves all available contacts.
     *
     * @return  a list of all found contacts
     */
    List<Contact> retrieveAllContacts();

    /**
     * Retrieves contact by given id.
     *
     * @param id
     *          the id
     * @return  the retrieved contact
     */
    Contact retrieveContactById(Long id);

}

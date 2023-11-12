package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.model.basemodel.Contact;
import com.project.repository.ContactRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ContactServiceImpl service class.
 * Implements ContactService interface.
 */
@Service
public class ContactServiceImpl implements ContactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepo contactRepo;

    /**
     * {@inheritDoc}
     * {@link com.project.service.ContactService#retrieveAllContacts()}.
     */
    @Override
    public List<Contact> retrieveAllContacts() {
        final Optional<List<Contact>> retrievedContacts = Optional.ofNullable(this.contactRepo.findAll());

        if(retrievedContacts.isPresent()) {
            return retrievedContacts.get();
        } else {
            LOGGER.error("No contacts found!");
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     * {@link com.project.service.ContactService#retrieveContactById(java.lang.Long)}.
     */
    @Override
    public Contact retrieveContactById(final Long id) {
        final Optional<Contact> retrievedContact = this.contactRepo.findById(id);

        if(retrievedContact.isPresent()) {
            return retrievedContact.get();
        } else {
            LOGGER.error("No contacts found!");
            return new Contact();
        }
    }

}

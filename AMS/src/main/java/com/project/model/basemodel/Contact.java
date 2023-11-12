package com.project.model.basemodel;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

/**
 * Contact model class.
 */
@Entity
@Table(name = "CONTACT")
@PrimaryKeyJoinColumn(name = "CONTACTS_ID")
public class Contact {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "CONTACT_SEQ_GEN", sequenceName = "CONTACT_SEQ",
            initialValue = 15, allocationSize = 1)
    @GeneratedValue(generator = "CONTACT_SEQ_GEN")
    private Long id;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @OneToMany(mappedBy = "contacts")
    private List<Location> locations;

    @OneToOne(mappedBy = "contacts")
    private Airport airport;

    @OneToMany(mappedBy = "contact")
    private Set<JobPosition> jobPositions;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Gets the email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Sets the email address.
     *
     * @param emailAddress
     *              the email address
     */
    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber
     *              the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}

package com.project.model.basemodel;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

/**
 * Airport model class.
 */
@Entity
@Table(name = "AIRPORT")
@PrimaryKeyJoinColumn(name = "AIRPORT_ID")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "airport")
    private Set<JobPosition> jobPositions;

    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contacts;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name
     *
     * @param name
     *          the name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the contacts
     *
     * @return the contacts
     */
    public Contact getContacts() {
        return this.contacts;
    }

    /**
     * Sets the contacts
     *
     * @param contacts
     *          the contacts
     */
    public void setContacts(final Contact contacts) {
        this.contacts = contacts;
    }

}

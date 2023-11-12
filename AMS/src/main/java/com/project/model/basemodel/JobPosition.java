package com.project.model.basemodel;

import java.time.LocalDateTime;

import com.project.enums.WorkingHours;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Transient;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

/**
 * JobPosition model class.
 */
@Entity
@Table(name = "JOB_POSITION")
@PrimaryKeyJoinColumn(name = "JOB_POSITION_ID")
public class JobPosition {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "JOB_POSITION_SEQ_GEN", sequenceName = "JOB_POSITION_SEQ",
            initialValue = 15, allocationSize = 1)
    @GeneratedValue(generator = "JOB_POSITION_SEQ_GEN")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "WORKING_HOURS")
    private WorkingHours workingHours;

    /** Status 'true' - open , 'false' - closed */
    @Column(name = "IS_OPEN")
    private boolean status;

    @Column(name = "REQUIREMENTS")
    private String requirements;

    @Column(name = "PUBLISHED_ON")
    private LocalDateTime publishingDate;

    @Column(name = "CLOSED_ON")
    private LocalDateTime closingDate;

    @Transient
    private long[] postedBefore;

    @ManyToOne
    @JoinColumn(name = "AIRPORT_ID")
    private Airport airport;

    @ManyToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @return the id
     */
    public void setId(final Long id) {
        this.id = id;
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
     * Gets the working hours.
     *
     * @return the working hours
     */
    public WorkingHours getWorkingHours() {
        return this.workingHours;
    }

    /**
     * Sets the working hours.
     *
     * @param workingHours
     *          the working hours
     */
    public void setWorkingHours(final WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    /**
     * Gets the status.
     *
     * @return true if position is open, otherwise false
     */
    public boolean isStatus() {
        return this.status;
    }

    /**
     * Sets the status
     *
     * @param status
     *          true if position is open, otherwise false
     */
    public void setStatus(final boolean status) {
        this.status = status;
    }

    /**
     * Gets the requirements.
     *
     * @return the requirements
     */
    public String getRequirements() {
        return this.requirements;
    }

    /**
     * Sets the requirements.
     *
     * @param requirements
     *              the requirements
     */
    public void setRequirements(final String requirements) {
        this.requirements = requirements;
    }

    /**
     * Gets the publishing date.
     *
     * @return the publishing date
     */
    public LocalDateTime getPublishingDate() {
        return this.publishingDate;
    }

    /**
     * Sets the publishing date.
     *
     * @param publishingDate
     *              the publishing date
     */
    public void setPublishingDate(final LocalDateTime publishingDate) {
        this.publishingDate = publishingDate;
    }

    /**
     * Gets the closing date.
     *
     * @return the closing date
     */
    public LocalDateTime getClosingDate() {
        return this.closingDate;
    }

    /**
     * Sets the closing date.
     *
     * @param closingDate
     *              the closing date
     */
    public void setClosingDate(final LocalDateTime closingDate) {
        this.closingDate = closingDate;
    }

    /**
     * Gets the time since the job position was posted
     *
     * @return the time
     */
    public long[] getPostedBefore() {
        return this.postedBefore;
    }

    /**
     * Sets the time since the job position was posted
     *
     * @param postedBefore
     *              the time
     */
    public void setPostedBefore(final long[] postedBefore) {
        this.postedBefore = postedBefore;
    }

    /**
     * Gets the specified airport.
     *
     * @return the specified airport
     */
    public Airport getAirport() {
        return this.airport;
    }

    /**
     * Sets the specified airport.
     *
     * @param airport
     *          the specified airport
     */
    public void setAirport(final Airport airport) {
        this.airport = airport;
    }

    /**
     * Gets the contacts.
     *
     * @return the contacts
     */
    public Contact getContact() {
        return this.contact;
    }

    /**
     * Sets the contacts.
     *
     * @param contact
     *          the contacts
     */
    public void setContact(final Contact contact) {
        this.contact = contact;
    }

}

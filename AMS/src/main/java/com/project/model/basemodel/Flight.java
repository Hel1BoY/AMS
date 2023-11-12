package com.project.model.basemodel;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import com.project.enums.FlightStatus;

/**
 * Flight model class.
 */
@Entity
@Table(name = "FLIGHTS")
@PrimaryKeyJoinColumn(name = "FLIGHT_ID")
public class Flight {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "FLIGHTS_SEQ_GEN", sequenceName = "FLIGHTS_SEQ",
            initialValue = 21, allocationSize = 1)
    @GeneratedValue(generator = "FLIGHTS_SEQ_GEN")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "AIRLINE_ID")
    private Airline airlineCompany;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private FlightStatus status;

    @Column(name = "DEPARTING_AT")
    private LocalDateTime departingAtTime;

    @ManyToOne
    @JoinColumn(name = "TO_LOCATION")
    private Location goingToLocation;

    @Column(name = "ARRIVED_AT")
    private LocalDateTime arrivedAtTime;

    @ManyToOne
    @JoinColumn(name = "FROM_LOCATION")
    private Location comingFromLocation;

    @OneToMany(mappedBy = "flight")
    private Set<Ticket> tickets;

    @Column(name = "LANDING_SECTOR")
    private byte landingSector;

    @Column(name = "ADDITIONAL_INFORMATION")
    private String additionalInformation;

    /**
     * Gets the id.
     *
     * @return  the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Gets the airlineCompany.
     *
     * @return  the airlineCompany
     */
    public Airline getAirlineCompany() {
        return this.airlineCompany;
    }

    /**
     * Sets the airlineCompany.
     *
     * @param airlineCompany
     *          the airlineCompany
     */
    public void setAirlineCompany(final Airline airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    /**
     * Gets the status.
     *
     * @return  the status
     */
    public FlightStatus getStatus() {
        return this.status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *          the status
     */
    public void setStatus(final FlightStatus status) {
        this.status = status;
    }

    /**
     * Gets the goingToLocation.
     *
     * @return  the goingToLocation
     */
    public Location getGoingToLocation() {
        return this.goingToLocation;
    }

    /**
     * Sets the goingToLocation.
     *
     * @param goingToLocation
     *              the goingToLocation
     */
    public void setGoingToLocation(final Location goingToLocation) {
        this.goingToLocation = goingToLocation;
    }

    /**
     * Gets the comingFromLocation.
     *
     * @return  the comingFromLocation
     */
    public Location getComingFromLocation() {
        return this.comingFromLocation;
    }

    /**
     * Sets the comingFromLocation.
     *
     * @param comingFromLocation
     *          the comingFromLocation
     */
    public void setComingFrom(final Location comingFromLocation) {
        this.comingFromLocation = comingFromLocation;
    }

    /**
     * Gets the tickets
     *
     * @return  the tickets
     */
    public Set<Ticket> getTickets() {
        return this.tickets;
    }

    /**
     * Sets the tickets.
     *
     * @param tickets
     *          the tickets
     */
    public void setTickets(final Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    /**
     * Gets the landingSector
     *
     * @return  landingSector
     */
    public byte getLandingSector() {
        return this.landingSector;
    }

    /**
     * Sets the landingSector.
     *
     * @param landingSector
     *          the landingSector
     */
    public void setLandingSector(final byte landingSector) {
        this.landingSector = landingSector;
    }

    /**
     * Gets the additionalInformation.
     *
     * @return  the additionalInformation
     */
    public String getAdditionalInformation() {
        return this.additionalInformation;
    }

    /**
     * Sets the additionalInformation.
     *
     * @param additionalInformation
     *          the additionalInformation
     */
    public void setAdditionalInformation(final String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    /**
     * Formats flight data for displaying.
     *
     * @return  the flight data
     */
    public String toStringFormatted() {
        return "Location - (" + this.getComingFromLocation().getCountry().getName() + ")" + //
                this.getComingFromLocation().getCity() + //
                ",Airline - " + this.getAirlineCompany().getName() + //
                ",Landing sector - " + this.getLandingSector() + ",Status - " + this.getStatus();
    }

}

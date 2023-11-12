package com.project.model.basemodel;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.OneToMany;

/**
 * Passenger model class.
 */
@Entity
@Table(name = "PASSENGER")
@PrimaryKeyJoinColumn(name = "PASSENGER_ID")
public class Passenger {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "PASSENGER_SEQ_GEN", sequenceName = "PASSENGER_SEQ",
            initialValue = 3, allocationSize = 1)
    @GeneratedValue(generator = "PASSENGER_SEQ_GEN")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTHDATE")
    private Date birthDate;

    @Column(name = "NATIONALITY")
    private String nationality;

    @OneToMany(mappedBy = "passenger")
    @Column(name = "TICKETS")
    private Set<Ticket> flightTickets;

    /**
     * Gets the id.
     *
     * @return  the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *          the id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return  the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *          the name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the birthdate.
     *
     * @return  the birthdate
     */
    public Date getBirthDate() {
        return this.birthDate;
    }

    /**
     * Sets the birthdate.
     *
     * @param birthDate
     *          the birthdate
     */
    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the nationality.
     *
     * @return  the nationality
     */
    public String getNationality() {
        return this.nationality;
    }

    /**
     * Sets the nationality.
     *
     * @param nationality
     *          the nationality
     */
    public void setNationality(final String nationality) {
        this.nationality = nationality;
    }

    /**
     * Gets the flight tickets
     *
     * @return  the flight tickets
     */
    public Set<Ticket> getFlightTickets() {
        return this.flightTickets;
    }

    /**
     * Sets the flight tickets.
     *
     * @param flightTickets
     *          the tickets.
     */
    public void setFlightTickets(final Set<Ticket> flightTickets) {
        this.flightTickets = flightTickets;
    }

}

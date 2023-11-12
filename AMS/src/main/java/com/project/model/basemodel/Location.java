package com.project.model.basemodel;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

/**
 * Location model class.
 */
@Entity
@Table(name = "LOCATION")
@PrimaryKeyJoinColumn(name = "LOCATION_ID")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @Column(name = "REGION")
    private String region;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String streetName;

    @Column(name = "STREET_NUMBER")
    private String streetNumber;

    @ManyToOne
    @JoinColumn(name = "CONTACTS_ID")
    private Contact contacts;

    @OneToMany(mappedBy = "comingFromLocation")
    private Set<Flight> flightsFrom;

    @OneToMany(mappedBy = "goingToLocation")
    private Set<Flight> flightsTo;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public Country getCountry() {
        return this.country;
    }

    /**
     * Sets the country.
     *
     * @param country
     *          the country
     */
    public void setCountry(final Country country) {
        this.country = country;
    }

    /**
     * Gets the region.
     *
     * @return the region
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * Sets the region.
     *
     * @param region
     *          the region
     */
    public void setRegion(final String region) {
        this.region = region;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city.
     *
     * @param city
     *          the city
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * Gets the street name.
     *
     * @return the street name
     */
    public String getStreet() {
        return this.streetName;
    }

    /**
     * Sets the street name.
     *
     * @param streetName
     *              the street name
     */
    public void setStreet(final String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets the street number.
     *
     * @return the street number
     */
    public String getStreetNumber() {
        return this.streetNumber;
    }

    /**
     * Sets the street number.
     *
     * @param streetNumber
     *              the street number
     */
    public void setStreetNumber(final String streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Gets the contacts.
     *
     * @return the contacts
     */
    public Contact getContacts() {
        return this.contacts;
    }

    /**
     * Sets the contacts.
     *
     * @param contacts
     *          the contacts
     */
    public void setContacts(final Contact contacts) {
        this.contacts = contacts;
    }

}

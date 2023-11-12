package com.project.model.basemodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.List;

/**
 * Airline model class.
 */
@Entity
@Table(name = "AIRLINE")
@PrimaryKeyJoinColumn(name = "AIRLINE_ID")
public class Airline {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "AIRLINE_SEQ_GEN", sequenceName = "AIRLINE_SEQ",
            initialValue = 15, allocationSize = 1)
    @GeneratedValue(generator = "AIRLINE_SEQ_GEN")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "classes")
    private List<String> classes;

    @OneToMany(mappedBy = "airlineCompany")
    private List<Flight> flights;

    /**
     * Gets the id.
     *
     * @return  the id
     */
    public Long getId() {
        return this.id;
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
     * Gets the classes.
     *
     * @return  the classes
     */
    public List<String> getClasses() {
        return this.classes;
    }

    /**
     * Sets the classes.
     *
     * @param classes
     *          the classes
     */
    public void setClasses(final List<String> classes) {
        this.classes = classes;
    }

}

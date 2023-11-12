package com.project.model.basemodel;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumns;

/**
 * Country model class.
 */
@Entity
@Table(name = "COUNTRY")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID"),
        @PrimaryKeyJoinColumn(name = "FROM_COUNTRY", referencedColumnName = "ID"),
        @PrimaryKeyJoinColumn(name = "TO_COUNTRY", referencedColumnName = "ID")
})
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @OneToMany(mappedBy = "country")
    private List<Location> location;

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
     * Sets the name.
     *
     * @param name
     *          the name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets the code.
     *
     * @param code
     *          the code
     */
    public void setCode(final String code) {
        this.code = code;
    }

}

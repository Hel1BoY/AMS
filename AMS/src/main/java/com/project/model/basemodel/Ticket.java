package com.project.model.basemodel;

import java.time.LocalDateTime;

import com.project.enums.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

/**
 * Ticket model class.
 */
@Entity
@Table(name = "TICKET")
@PrimaryKeyJoinColumn(name = "TICKET_ID")
public class Ticket {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "TICKET_SEQ_GEN", sequenceName = "TICKET_SEQ",
            initialValue = 2, allocationSize = 1)
    @GeneratedValue(generator = "TICKET_SEQ_GEN")
    private Long id;

    @Column(name = "TICKET_CODE")
    private String ticketCode;

    @ManyToOne
    @JoinColumn(name = "PASSENGER_ID")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

    @Column(name = "SEAT_NUMBER")
    private short seatNumber;

    @Column(name = "GATE")
    private short gate;

    @Column(name = "DEPARTING_AT")
    private LocalDateTime timestampOfDeparting;

    @Column(name = "BOUGHT_ON")
    private LocalDateTime dateTimeOfBuying;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_TYPE")
    private PaymentType typeOfBuying;

    /**
     * Gets the id.
     *
     * @return  the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Gets the passenger.
     *
     * @return  the passenger
     */
    public Passenger getPassenger() {
        return this.passenger;
    }

    /**
     * Sets the passenger.
     *
     * @param passenger
     *          the passenger
     */
    public void setPassenger(final Passenger passenger) {
        this.passenger = passenger;
    }

    /**
     * Gets the flight.
     *
     * @return  the flight
     */
    public Flight getFlight() {
        return this.flight;
    }

    /**
     * Sets the flight.
     *
     * @param flight
     *          the flight
     */
    public void setFlight(final Flight flight) {
        this.flight = flight;
    }

    /**
     * Gets the seat number.
     *
     * @return  the seat number
     */
    public short getSeatNumber() {
        return this.seatNumber;
    }

    /**
     * Sets the seat number.
     *
     * @param seatNumber
     *          the seat number
     */
    public void setSeatNumber(final short seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * Gets the gate.
     *
     * @return  the gate
     */
    public short getGate() {
        return this.gate;
    }

    /**
     * Sets the gate.
     *
     * @param gate
     *          the gate
     */
    public void setGate(final short gate) {
        this.gate = gate;
    }

    /**
     * Gets the flight departing timestamp.
     *
     * @return the flight departing timestamp
     */
    public LocalDateTime getTimestampOfDeparting() {
        return this.timestampOfDeparting;
    }

    /**
     * Sets the flight departing timestamp
     *
     * @param timestampOfDeparting
     *          the flight departing timestamp
     */
    public void setTimestampOfDeparting(final LocalDateTime timestampOfDeparting) {
        this.timestampOfDeparting = timestampOfDeparting;
    }

    /**
     * Gets the date and time of buying the ticket.
     *
     * @return the date and time of buying the ticket
     */
    public LocalDateTime getDateTimeOfBuying() {
        return this.dateTimeOfBuying;
    }

    /**
     * Sets the date and time of buying the ticket
     *
     * @param dateTimeOfBuying
     *          the date and time of buying the ticket
     */
    public void setDateTimeOfBuying(final LocalDateTime dateTimeOfBuying) {
        this.dateTimeOfBuying = dateTimeOfBuying;
    }

    /**
     * Gets the type of buying the ticket.
     *
     * @return  the type of buying the ticket
     */
    public PaymentType getTypeOfBuying() {
        return this.typeOfBuying;
    }

    /**
     * Sets the type of buying the ticket.
     *
     * @param typeOfBuying
     *          the type of buying the ticket
     */
    public void setTypeOfBuying(final PaymentType typeOfBuying) {
        this.typeOfBuying = typeOfBuying;
    }

}

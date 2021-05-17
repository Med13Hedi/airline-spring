package com.airline.airline.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Flight {//schedule + flight
    //scheduledFlight work
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private int capacity;//flight

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeOfDeparture;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  timeOfArrival;

    @NotNull
    @OneToOne(fetch=FetchType.EAGER)
    private Airport airportOrigin;
    @NotNull
    @OneToOne(fetch=FetchType.EAGER)
    private Airport airportDestination;

    public Flight() {
    }

    public Flight(Long id, int capacity, LocalDateTime timeOfDeparture, LocalDateTime timeOfArrival, Airport airportOrigin, Airport airportDestination) {
        this.id = id;
        this.capacity = capacity;
        this.timeOfDeparture = timeOfDeparture;
        this.timeOfArrival = timeOfArrival;
        this.airportOrigin = airportOrigin;
        this.airportDestination = airportDestination;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", timeOfDeparture=" + timeOfDeparture +
                ", timeOfArrival=" + timeOfArrival +
                ", airportOrigin=" + airportOrigin +
                ", airportDestination=" + airportDestination +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(LocalDateTime timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public LocalDateTime getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(LocalDateTime timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public Airport getAirportOrigin() {
        return airportOrigin;
    }

    public void setAirportOrigin(Airport airportOrigin) {
        this.airportOrigin = airportOrigin;
    }

    public Airport getAirportDestination() {
        return airportDestination;
    }

    public void setAirportDestination(Airport airportDestination) {
        this.airportDestination = airportDestination;
    }
}

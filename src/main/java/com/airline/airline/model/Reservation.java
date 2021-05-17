package com.airline.airline.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private LocalDate reservationDate;
    @Column(nullable = false)
    private int nOfPassengers;

    public Reservation() {
    }

    public Reservation(Long id,
                       LocalDate reservationDate,
                       int nOfPassengers) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.nOfPassengers = nOfPassengers;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationDate=" + reservationDate +
                ", nOfPassengers=" + nOfPassengers +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }



    public int getnOfPassengers() {
        return nOfPassengers;
    }

    public void setnOfPassengers(int nOfPassengers) {
        this.nOfPassengers = nOfPassengers;
    }
}

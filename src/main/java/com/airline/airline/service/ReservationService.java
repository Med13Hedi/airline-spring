package com.airline.airline.service;

import com.airline.airline.model.Airport;
import com.airline.airline.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> findAllReservations();
    Reservation findReservationById(Long id);

    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);

    void deleteReservationById(Long id);

}

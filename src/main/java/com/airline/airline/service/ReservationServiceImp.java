package com.airline.airline.service;

import com.airline.airline.exception.notFoundException;
import com.airline.airline.model.Reservation;
import com.airline.airline.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImp implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findReservationById(Long id) {
        return reservationRepository.findReservationById(id)
                .orElseThrow(() -> new notFoundException("Reservation by id" + id + "was NOT FOUND"));
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteReservationById(id);
    }
}

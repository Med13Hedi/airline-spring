package com.airline.airline.repository;

import com.airline.airline.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findReservationById(Long id);

    void deleteReservationById(Long id);
}

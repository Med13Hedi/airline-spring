package com.airline.airline.repository;

import com.airline.airline.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findFlightById(Long id);

    void deleteFlightById(Long id);
}

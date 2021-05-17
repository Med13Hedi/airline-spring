package com.airline.airline.repository;

import com.airline.airline.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findAirportById(Long id);

    void deleteAirportById(Long id);
}

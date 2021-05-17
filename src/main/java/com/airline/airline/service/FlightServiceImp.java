package com.airline.airline.service;

import com.airline.airline.exception.notFoundException;
import com.airline.airline.model.Flight;
import com.airline.airline.repository.AirportRepository;
import com.airline.airline.repository.FlightRepository;
import com.airline.airline.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FlightServiceImp implements FlightService{
    @Autowired
    FlightRepository flightRepository;


    @Override
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight findFlightById(Long id) {
        return flightRepository.findFlightById(id)
                .orElseThrow(() -> new notFoundException("flight by id" + id + "was NOT FOUND"));
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlightById(Long id) {
        flightRepository.deleteFlightById(id);
    }
}

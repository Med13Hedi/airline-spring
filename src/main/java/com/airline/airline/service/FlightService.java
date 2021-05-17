package com.airline.airline.service;



import com.airline.airline.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> findAllFlights();
    Flight findFlightById(Long id);

    Flight addFlight(Flight flight);
    Flight updateFlight(Flight flight);

    void deleteFlightById(Long id);
}

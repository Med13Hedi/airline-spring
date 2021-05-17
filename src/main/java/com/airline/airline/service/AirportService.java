package com.airline.airline.service;

import com.airline.airline.model.Airport;
import java.util.List;


public interface AirportService {
    List<Airport> findAllAirports();
    Airport findAirportById(Long id);

    Airport addAirport(Airport airport);
    Airport updateAirport(Airport airport);

    void deleteAirportById(Long id);
}

package com.airline.airline.service;

import com.airline.airline.exception.notFoundException;
import com.airline.airline.model.Airport;
import com.airline.airline.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirportServiceImp implements AirportService{
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport findAirportById(Long id) {
        return airportRepository.findAirportById(id)
                .orElseThrow(() -> new notFoundException("Airport by id" + id + "was NOT FOUND"));
    }

    @Override
    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public void deleteAirportById(Long id) {
        airportRepository.deleteAirportById(id);
    }
}

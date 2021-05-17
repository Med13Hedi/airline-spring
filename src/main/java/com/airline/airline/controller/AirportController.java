package com.airline.airline.controller;

import com.airline.airline.model.Airport;
import com.airline.airline.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping("")
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = airportService.findAllAirports();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable("id") Long id) {
        Airport airport = airportService.findAirportById(id);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
        Airport newAirport = airportService.addAirport(airport);
        return new ResponseEntity<>(newAirport, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAirport(@PathVariable("id") Long id) {
        airportService.deleteAirportById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id,
                                                 @RequestBody Airport airportDetails) {
        Airport airport = airportService.findAirportById(id);

        airport.setName(airportDetails.getName());
        airport.setLocation(airportDetails.getLocation());

        airportService.updateAirport(airport);

        return new ResponseEntity<>(airport, HttpStatus.OK);
    }
}

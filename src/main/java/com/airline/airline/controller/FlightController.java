package com.airline.airline.controller;

import com.airline.airline.model.Customer;
import com.airline.airline.model.Flight;
import com.airline.airline.service.AirportService;
import com.airline.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;
    @Autowired
    AirportService airportService;


    @GetMapping("")
    public ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> flights = flightService.findAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") Long id){
        Flight flight = flightService.findFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
//        flight.setAirportDestination(airportService.findAirportById(flight.getAirportDestination().getId()));
//        flight.setAirportOrigin(airportService.findAirportById(flight.getAirportOrigin().getId()));
//        flight.setTimeOfArrival(flight.getTimeOfArrival());
        Flight newFlight = flightService.addFlight(flight);

        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable("id") Long id){
        flightService.deleteFlightById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id,@RequestBody Flight flightDetails){
        Flight flight = flightService.findFlightById(id);

        flight.setCapacity(flightDetails.getCapacity());
        flight.setTimeOfDeparture(flightDetails.getTimeOfDeparture());
        flight.setTimeOfArrival(flightDetails.getTimeOfArrival());
        flight.setAirportOrigin(flightDetails.getAirportOrigin());
        flight.setAirportDestination(flightDetails.getAirportDestination());

        flightService.updateFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

}

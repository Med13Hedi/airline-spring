package com.airline.airline.controller;

import com.airline.airline.model.Customer;
import com.airline.airline.model.Reservation;
import com.airline.airline.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("")
    public ResponseEntity<List<Reservation>> getAllReservations(){
        List<Reservation> reservations = reservationService.findAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id){
        Reservation customer = reservationService.findReservationById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
        Reservation newReservation = reservationService.addReservation(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable("id") Long id){
        reservationService.deleteReservationById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id,@RequestBody Reservation reservationDetails){
        Reservation reservation = reservationService.findReservationById(id);

        reservation.setReservationDate(reservationDetails.getReservationDate());
        reservation.setnOfPassengers(reservationDetails.getnOfPassengers());


        reservationService.updateReservation(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }



}

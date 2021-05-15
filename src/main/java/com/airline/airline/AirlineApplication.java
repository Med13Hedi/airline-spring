package com.airline.airline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class AirlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineApplication.class, args);
	}

//	@GetMapping
//	public List<Customer> Hello(){
//		return List.of(
//				new Customer(
//						1L,
//						"Med Hedi",
//						"medhedib@gmail.com",
//						"90478329",
//						LocalDate.of(1998,6,13),
//						"Tunisia"
//				)
//		);
//	}
}

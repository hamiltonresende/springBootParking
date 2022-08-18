package com.api.springParkingControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringParkingControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringParkingControlApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "Initiating test spring boot";
	}

}

package com.transport.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusTransportationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusTransportationSystemApplication.class, args);

		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                Bus Transportation System Application Running               ");
		System.out.println("----------------------------------------------------------------------------");
	}

}

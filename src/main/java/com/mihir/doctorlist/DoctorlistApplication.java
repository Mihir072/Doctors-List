package com.mihir.doctorlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorlistApplication {

	public static void main(String[] args) {
		try {
			System.setProperty("server.port", "8080");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SpringApplication.run(DoctorlistApplication.class, args);
	}

}

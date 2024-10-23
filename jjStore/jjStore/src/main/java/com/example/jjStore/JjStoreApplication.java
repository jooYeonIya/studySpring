package com.example.jjStore;

import jakarta.servlet.annotation.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class JjStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(JjStoreApplication.class, args);
	}

}

package com.abdul.boot.brewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.abdul.boot.brewer.domain")
public class BrewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrewerApplication.class, args);
	}

}

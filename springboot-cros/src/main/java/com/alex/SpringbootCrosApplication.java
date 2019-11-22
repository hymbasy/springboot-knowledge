package com.alex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootCrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrosApplication.class, args);
	}

}

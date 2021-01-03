package ru.sidorin.corona_statistics_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronaStatisticsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaStatisticsAppApplication.class, args);
	}

}

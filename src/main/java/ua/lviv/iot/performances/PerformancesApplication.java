package ua.lviv.iot.performances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ua.lviv.iot.performances.controller")
public class PerformancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformancesApplication.class, args);
	}

}

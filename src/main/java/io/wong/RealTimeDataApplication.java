package io.wong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"controller","dao","models","io.wong","socketConfig"})
@EntityScan("models")
@EnableJpaRepositories("dao")
@EnableScheduling
public class RealTimeDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeDataApplication.class, args);
	}
}

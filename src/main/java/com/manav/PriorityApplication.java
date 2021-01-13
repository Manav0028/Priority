package com.manav;

import com.manav.api.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class PriorityApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriorityApplication.class, args);
	}

}

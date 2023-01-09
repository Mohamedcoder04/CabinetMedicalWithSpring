package com.gestion.cabinetmedical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CabinetmedicalApplication {
	public static void main(String[] args) {
		SpringApplication.run(CabinetmedicalApplication.class, args);
	}
}

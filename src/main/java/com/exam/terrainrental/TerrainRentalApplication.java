package com.exam.terrainrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TerrainRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TerrainRentalApplication.class, args);
    }

}

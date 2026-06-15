package com.exam.terrainrental.config;

import com.exam.terrainrental.model.entity.Booking;
import com.exam.terrainrental.model.entity.Terrain;
import com.exam.terrainrental.model.enums.BookingStatus;
import com.exam.terrainrental.repository.BookingRepository;
import com.exam.terrainrental.repository.TerrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final TerrainRepository terrainRepository;
    private final BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception {
        if (terrainRepository.count() == 0) {
            Terrain t1 = Terrain.builder()
                    .ownerId(1L)
                    .title("Beautiful Countryside Meadow")
                    .description("A large green meadow perfect for weddings or events.")
                    .location("Green Valley, CA")
                    .areaSize(new BigDecimal("2500.50"))
                    .pricePerDay(new BigDecimal("150.00"))
                    .availableFrom(LocalDateTime.now().plusDays(1))
                    .availableTo(LocalDateTime.now().plusMonths(6))
                    .isAvailable(true)
                    .build();

            Terrain t2 = Terrain.builder()
                    .ownerId(2L)
                    .title("Rocky Mountain Plot")
                    .description("Stunning mountain views, ideal for photography.")
                    .location("Aspen, CO")
                    .areaSize(new BigDecimal("1200.00"))
                    .pricePerDay(new BigDecimal("300.00"))
                    .availableFrom(LocalDateTime.now())
                    .availableTo(LocalDateTime.now().plusMonths(12))
                    .isAvailable(true)
                    .build();

            terrainRepository.saveAll(Arrays.asList(t1, t2));

            Booking b1 = Booking.builder()
                    .terrain(t1)
                    .renterId(10L)
                    .startDate(LocalDateTime.now().plusDays(5))
                    .endDate(LocalDateTime.now().plusDays(7))
                    .totalPrice(new BigDecimal("300.00"))
                    .status(BookingStatus.PENDING)
                    .build();

            bookingRepository.save(b1);

            System.out.println("Database seeded with sample terrains and bookings.");
        }
    }
}

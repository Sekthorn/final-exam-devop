package com.exam.terrainrental.repository;

import com.exam.terrainrental.model.entity.Booking;
import com.exam.terrainrental.model.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRenterId(Long renterId);
    List<Booking> findByTerrainId(Long terrainId);
    List<Booking> findByStatus(BookingStatus status);
}

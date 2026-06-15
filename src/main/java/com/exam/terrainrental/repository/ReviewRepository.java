package com.exam.terrainrental.repository;

import com.exam.terrainrental.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByTerrainId(Long terrainId);
    List<Review> findByUserId(Long userId);
}

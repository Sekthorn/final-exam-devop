package com.exam.terrainrental.repository;

import com.exam.terrainrental.model.entity.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {
    List<Terrain> findByOwnerId(Long ownerId);
    List<Terrain> findByIsAvailableTrue();
}

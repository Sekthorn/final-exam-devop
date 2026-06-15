package com.exam.terrainrental.controller;

import com.exam.terrainrental.model.entity.Terrain;
import com.exam.terrainrental.repository.TerrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terrains")
@RequiredArgsConstructor
public class TerrainController {

    private final TerrainRepository terrainRepository;

    @GetMapping
    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Terrain> getTerrainById(@PathVariable Long id) {
        return terrainRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Terrain createTerrain(@RequestBody Terrain terrain) {
        return terrainRepository.save(terrain);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Terrain> updateTerrain(@PathVariable Long id, @RequestBody Terrain terrainDetails) {
        return terrainRepository.findById(id)
                .map(terrain -> {
                    terrain.setOwnerId(terrainDetails.getOwnerId());
                    terrain.setTitle(terrainDetails.getTitle());
                    terrain.setDescription(terrainDetails.getDescription());
                    terrain.setLocation(terrainDetails.getLocation());
                    terrain.setAreaSize(terrainDetails.getAreaSize());
                    terrain.setPricePerDay(terrainDetails.getPricePerDay());
                    terrain.setAvailableFrom(terrainDetails.getAvailableFrom());
                    terrain.setAvailableTo(terrainDetails.getAvailableTo());
                    terrain.setIsAvailable(terrainDetails.getIsAvailable());
                    terrain.setMainImageId(terrainDetails.getMainImageId());
                    return ResponseEntity.ok(terrainRepository.save(terrain));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Long id) {
        return terrainRepository.findById(id)
                .map(terrain -> {
                    terrainRepository.delete(terrain);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

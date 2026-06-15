package com.exam.terrainrental.controller;

import com.exam.terrainrental.model.entity.TerrainImage;
import com.exam.terrainrental.repository.TerrainImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terrain-images")
@RequiredArgsConstructor
public class TerrainImageController {

    private final TerrainImageRepository terrainImageRepository;

    @GetMapping
    public List<TerrainImage> getAllImages() {
        return terrainImageRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TerrainImage> getImageById(@PathVariable Long id) {
        return terrainImageRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TerrainImage createImage(@RequestBody TerrainImage image) {
        return terrainImageRepository.save(image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        return terrainImageRepository.findById(id)
                .map(image -> {
                    terrainImageRepository.delete(image);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

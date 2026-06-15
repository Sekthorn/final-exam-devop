package com.exam.terrainrental.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "terrain_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TerrainImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terrain_id", nullable = false)
    private Terrain terrain;

    @Column(nullable = false)
    private String imagePath;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime uploadedAt;
}

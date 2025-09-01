package org.factoriaf5.digiital_academy.dto;


import java.time.LocalDateTime;

public class SolicitudResponse {
    private Long id;
    private LocalDateTime createdAt;

    public SolicitudResponse(Long id, LocalDateTime createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Getters
}


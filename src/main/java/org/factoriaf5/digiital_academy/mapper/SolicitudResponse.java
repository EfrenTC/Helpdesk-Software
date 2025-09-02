package org.factoriaf5.digiital_academy.mapper;

import java.time.LocalDateTime;

public class SolicitudResponse {
    private Long id;
    private String estado;
    private String nombre;
    private LocalDateTime fechaSolicitud;
    private String tema;
    private LocalDateTime createdAt;
    private LocalDateTime attendedAt;
    private String tecnico;

    public SolicitudResponse(Long id, String estado, String nombre, LocalDateTime fechaSolicitud,
            String tema, LocalDateTime createdAt, LocalDateTime attendedAt, String tecnico) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.fechaSolicitud = fechaSolicitud;
        this.tema = tema;
        this.createdAt = createdAt;
        this.attendedAt = attendedAt;
        this.tecnico = tecnico;
    }

    public Long getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public String getTema() {
        return tema;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getAttendedAt() {
        return attendedAt;
    }

    public String getTecnico() {
        return tecnico;
    }
}

package org.factoriaf5.digiital_academy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SolicitudRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "La fecha de la solicitud es obligatoria")
    private LocalDateTime fechaSolicitud;

    @NotNull(message = "El tema es obligatorio")
    private Long temaId;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static class SolicitudAtenderRequest {

        @NotBlank(message = "El nombre del técnico es obligatorio")
        private String nombreTecnico;

        public String getNombreTecnico() {
            return nombreTecnico;
        }

        public void setNombreTecnico(String nombreTecnico) {
            this.nombreTecnico = nombreTecnico;
        }
    }
}
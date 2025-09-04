package org.factoriaf5.digiital_academy.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SolicitudResponseTest {

    @Test
    void constructorYGetters_DeberianRetornarValoresCorrectos() {
        Long id = 1L;
        String estado = "PENDIENTE";
        String nombre = "Juan Pérez";
        LocalDateTime fechaSolicitud = LocalDateTime.now();
        String tema = "Soporte Técnico";
        LocalDateTime createdAt = LocalDateTime.now().minusDays(1);
        LocalDateTime updatedAt = LocalDateTime.now();
        LocalDateTime attendedAt = LocalDateTime.now().plusDays(1);
        String tecnico = "Técnico1";

        SolicitudResponse response = new SolicitudResponse(
                id, estado, nombre, fechaSolicitud, tema,
                createdAt, updatedAt, attendedAt, tecnico);

        assertEquals(id, response.getId());
        assertEquals(estado, response.getEstado());
        assertEquals(nombre, response.getNombre());
        assertEquals(fechaSolicitud, response.getFechaSolicitud());
        assertEquals(tema, response.getTema());
        assertEquals(createdAt, response.getCreatedAt());
        assertEquals(updatedAt, response.getUpdatedAt());
        assertEquals(attendedAt, response.getAttendedAt());
        assertEquals(tecnico, response.getTecnico());
    }
}

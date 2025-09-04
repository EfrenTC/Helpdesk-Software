package org.factoriaf5.digiital_academy.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SolicitudTest {

    private Solicitud solicitud;
    private Tema tema;

    @BeforeEach
    void setUp() {
        solicitud = new Solicitud();
        tema = new Tema();
        tema.setId(1L);
        tema.setNombre("Soporte Técnico");
    }

    @Test
    void testGettersAndSetters() {
        solicitud.setId(10L);
        solicitud.setNombre("Juan Pérez");
        solicitud.setFechaSolicitud(LocalDateTime.of(2025, 9, 4, 10, 30));
        solicitud.setTema(tema);
        solicitud.setDescripcion("Problema con la computadora");
        solicitud.setEstado("Pendiente");
        solicitud.setTecnico("Técnico 1");
        solicitud.setCreatedAt(LocalDateTime.of(2025, 9, 4, 9, 0));
        solicitud.setUpdatedAt(LocalDateTime.of(2025, 9, 4, 10, 0));
        solicitud.setAttendedAt(LocalDateTime.of(2025, 9, 4, 11, 0));

        assertEquals(10L, solicitud.getId());
        assertEquals("Juan Pérez", solicitud.getNombre());
        assertEquals(LocalDateTime.of(2025, 9, 4, 10, 30), solicitud.getFechaSolicitud());
        assertEquals(tema, solicitud.getTema());
        assertEquals("Problema con la computadora", solicitud.getDescripcion());
        assertEquals("Pendiente", solicitud.getEstado());
        assertEquals("Técnico 1", solicitud.getTecnico());
        assertEquals(LocalDateTime.of(2025, 9, 4, 9, 0), solicitud.getCreatedAt());
        assertEquals(LocalDateTime.of(2025, 9, 4, 10, 0), solicitud.getUpdatedAt());
        assertEquals(LocalDateTime.of(2025, 9, 4, 11, 0), solicitud.getAttendedAt());
    }

}

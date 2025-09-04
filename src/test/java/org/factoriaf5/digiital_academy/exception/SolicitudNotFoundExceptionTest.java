package org.factoriaf5.digiital_academy.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolicitudNotFoundExceptionTest {

    @Test
    void constructorConMensaje_DeberiaRetornarMensajeCorrecto() {
        String mensaje = "Solicitud no encontrada";
        SolicitudNotFoundException exception = new SolicitudNotFoundException(mensaje);

        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void constructorConId_DeberiaConstruirMensajeCorrecto() {
        Long id = 42L;
        SolicitudNotFoundException exception = new SolicitudNotFoundException(id);

        assertEquals("Solicitud no encontrada con id " + id, exception.getMessage());
    }
}

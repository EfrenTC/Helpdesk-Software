package org.factoriaf5.digiital_academy.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BadRequestExceptionTest {

    @Test
    void crearBadRequestException_DeberiaTenerMensajeCorrecto() {
        String mensaje = "Solicitud inválida";

        BadRequestException exception = assertThrows(
                BadRequestException.class,
                () -> {
                    throw new BadRequestException(mensaje);
                });

        assertEquals(mensaje, exception.getMessage());
    }
}

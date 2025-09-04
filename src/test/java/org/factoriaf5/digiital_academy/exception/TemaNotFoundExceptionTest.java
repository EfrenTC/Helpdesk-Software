package org.factoriaf5.digiital_academy.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TemaNotFoundExceptionTest {

    @Test
    void crearTemaNotFoundException_DeberiaTenerMensajeCorrecto() {
        String mensaje = "Tema no encontrado";

        TemaNotFoundException exception = assertThrows(
                TemaNotFoundException.class,
                () -> {
                    throw new TemaNotFoundException(mensaje);
                });

        assertEquals(mensaje, exception.getMessage());
    }
}

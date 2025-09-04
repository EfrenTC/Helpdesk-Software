package org.factoriaf5.digiital_academy.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemaResponseTest {

    @Test
    void constructorYGetters_DeberianRetornarValoresCorrectos() {
        Long id = 10L;
        String nombre = "Soporte Técnico";

        TemaResponse response = new TemaResponse(id, nombre);

        assertEquals(id, response.getId(), "El ID debería coincidir con el valor pasado al constructor");
        assertEquals(nombre, response.getNombre(), "El nombre debería coincidir con el valor pasado al constructor");
    }
}

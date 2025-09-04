package org.factoriaf5.digiital_academy.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemaTest {

    private Tema tema;

    @BeforeEach
    void setUp() {
        tema = new Tema();
    }

    @Test
    void testGettersAndSetters() {
        tema.setId(1L);
        tema.setNombre("Soporte Técnico");

        assertEquals(1L, tema.getId());
        assertEquals("Soporte Técnico", tema.getNombre());
    }

}

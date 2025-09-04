package org.factoriaf5.digiital_academy.controller;

import org.factoriaf5.digiital_academy.dto.TemaResponse;
import org.factoriaf5.digiital_academy.service.TemaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TemaControllerTest {

    @Mock
    private TemaService temaService;

    @InjectMocks
    private TemaController temaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarTemas_debeDevolverListaDeTemas() {
        TemaResponse tema1 = new TemaResponse(1L, "Soporte Técnico");
        TemaResponse tema2 = new TemaResponse(2L, "Incidencias");
        List<TemaResponse> temasMock = Arrays.asList(tema1, tema2);

        when(temaService.listarTemas()).thenReturn(temasMock);

        ResponseEntity<List<TemaResponse>> response = temaController.listarTemas();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals("Soporte Técnico", response.getBody().get(0).getNombre());
        assertEquals("Incidencias", response.getBody().get(1).getNombre());
    }

}

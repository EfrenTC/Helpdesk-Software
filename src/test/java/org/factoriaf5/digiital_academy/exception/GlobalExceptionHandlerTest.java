package org.factoriaf5.digiital_academy.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handleSolicitudNotFound_devuelve404() {
        SolicitudNotFoundException ex = new SolicitudNotFoundException("Solicitud no encontrada");
        ResponseEntity<String> response = handler.handleSolicitudNotFound(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Solicitud no encontrada", response.getBody());
    }

    @Test
    void handleTemaNotFound_devuelve400() {
        TemaNotFoundException ex = new TemaNotFoundException("Tema no encontrado");
        ResponseEntity<String> response = handler.handleTemaNotFound(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Tema no encontrado", response.getBody());
    }

    @Test
    void handleBadRequest_devuelve409() {
        BadRequestException ex = new BadRequestException("Solicitud inválida");
        ResponseEntity<String> response = handler.handleBadRequest(ex);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Solicitud inválida", response.getBody());
    }
}

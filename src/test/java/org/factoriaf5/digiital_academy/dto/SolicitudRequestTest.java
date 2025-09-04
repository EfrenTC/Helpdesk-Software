package org.factoriaf5.digiital_academy.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolicitudRequestTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void solicitudRequest_validaCorrectamente() {
        SolicitudRequest request = new SolicitudRequest();
        request.setNombre("Juan Pérez");
        request.setFechaSolicitud(LocalDateTime.now());
        request.setTemaId(1L);
        request.setDescripcion("Problema con la impresora");

        Set<ConstraintViolation<SolicitudRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty(), "No debe haber violaciones de validación");
    }

    @Test
    void solicitudRequest_faltanCampos_devuelveErrores() {
        SolicitudRequest request = new SolicitudRequest();

        Set<ConstraintViolation<SolicitudRequest>> violations = validator.validate(request);
        assertEquals(4, violations.size(), "Debe haber 4 violaciones por campos obligatorios");
    }

    @Test
    void solicitudAtenderRequest_validaCorrectamente() {
        SolicitudRequest.SolicitudAtenderRequest atenderRequest = new SolicitudRequest.SolicitudAtenderRequest();
        atenderRequest.setNombreTecnico("María López");

        Set<ConstraintViolation<SolicitudRequest.SolicitudAtenderRequest>> violations = validator
                .validate(atenderRequest);
        assertTrue(violations.isEmpty(), "No debe haber violaciones de validación");
    }

    @Test
    void solicitudAtenderRequest_sinNombreTecnico_devuelveError() {
        SolicitudRequest.SolicitudAtenderRequest atenderRequest = new SolicitudRequest.SolicitudAtenderRequest();

        Set<ConstraintViolation<SolicitudRequest.SolicitudAtenderRequest>> violations = validator
                .validate(atenderRequest);
        assertEquals(1, violations.size(), "Debe haber 1 violación por nombreTecnico obligatorio");
        assertEquals("El nombre del técnico es obligatorio", violations.iterator().next().getMessage());
    }
}

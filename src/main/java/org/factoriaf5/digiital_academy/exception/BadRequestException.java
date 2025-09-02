package org.factoriaf5.digiital_academy.exception;

/**
 * Excepción para errores de lógica de negocio que deben mapearse a 4xx.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

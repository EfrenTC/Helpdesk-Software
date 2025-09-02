package org.factoriaf5.digiital_academy.exception;

public class SolicitudNotFoundException extends RuntimeException {

    public SolicitudNotFoundException(String message) {
        super(message);
    }

    public SolicitudNotFoundException(Long id) {
        super("Solicitud no encontrada con id " + id);
    }
}

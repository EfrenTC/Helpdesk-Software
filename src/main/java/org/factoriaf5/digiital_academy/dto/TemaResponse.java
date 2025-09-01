package org.factoriaf5.digiital_academy.dto;

public class TemaResponse {
    private Long id;
    private String nombre;

    public TemaResponse(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

   
}
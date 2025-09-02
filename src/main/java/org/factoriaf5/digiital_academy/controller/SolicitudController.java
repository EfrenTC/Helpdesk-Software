package org.factoriaf5.digiital_academy.controller;

import org.factoriaf5.digiital_academy.dto.SolicitudRequest;
import org.factoriaf5.digiital_academy.dto.SolicitudResponse;
import org.factoriaf5.digiital_academy.service.SolicitudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping
    public ResponseEntity<SolicitudResponse> crearSolicitud(@Valid @RequestBody SolicitudRequest request) {
        SolicitudResponse response = solicitudService.crearSolicitud(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SolicitudResponse>> listarSolicitudes() {
        List<SolicitudResponse> response = solicitudService.listarSolicitudesOrdenadas();
        return ResponseEntity.ok(response);
    }
}

package org.factoriaf5.digiital_academy.controller;

import org.factoriaf5.digiital_academy.dto.TemaResponse;
import org.factoriaf5.digiital_academy.service.TemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temas")
public class TemaController {

    private final TemaService temaService;

    public TemaController(TemaService temaService) {
        this.temaService = temaService;
    }

    @GetMapping
    public ResponseEntity<List<TemaResponse>> listarTemas() {
        List<TemaResponse> response = temaService.listarTemas();
        return ResponseEntity.ok(response);
    }
}
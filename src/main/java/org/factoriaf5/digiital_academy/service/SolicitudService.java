package org.factoriaf5.digiital_academy.service;


import org.factoriaf5.digiital_academy.dto.SolicitudRequest;
import org.factoriaf5.digiital_academy.dto.SolicitudResponse;
import org.factoriaf5.digiital_academy.model.Solicitud;
import org.factoriaf5.digiital_academy.model.Tema;
import org.factoriaf5.digiital_academy.repository.SolicitudRepository;
import org.factoriaf5.digiital_academy.repository.TemaRepository;
import org.factoriaf5.digiital_academy.exception.TemaNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final TemaRepository temaRepository;

    public SolicitudService(SolicitudRepository solicitudRepository, TemaRepository temaRepository) {
        this.solicitudRepository = solicitudRepository;
        this.temaRepository = temaRepository;
    }

    public SolicitudResponse crearSolicitud(SolicitudRequest request) {
        Tema tema = temaRepository.findById(request.getTemaId())
                .orElseThrow(() -> new TemaNotFoundException("Tema no encontrado"));

        Solicitud solicitud = new Solicitud();
        solicitud.setNombre(request.getNombre());
        solicitud.setFechaSolicitud(request.getFechaSolicitud());
        solicitud.setTema(tema);
        solicitud.setDescripcion(request.getDescripcion());
        solicitud.setEstado("PENDIENTE");
        solicitud.setCreatedAt(LocalDateTime.now());

        Solicitud saved = solicitudRepository.save(solicitud);
        return new SolicitudResponse(saved.getId(), saved.getCreatedAt());
    }
}


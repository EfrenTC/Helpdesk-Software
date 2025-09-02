package org.factoriaf5.digiital_academy.service;

import org.factoriaf5.digiital_academy.dto.SolicitudRequest;
import org.factoriaf5.digiital_academy.dto.SolicitudResponse;
import org.factoriaf5.digiital_academy.model.Solicitud;
import org.factoriaf5.digiital_academy.model.Tema;
import org.factoriaf5.digiital_academy.repository.SolicitudRepository;
import org.factoriaf5.digiital_academy.repository.TemaRepository;
import org.factoriaf5.digiital_academy.exception.TemaNotFoundException;
import org.factoriaf5.digiital_academy.exception.SolicitudNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        return mapToResponse(saved);
    }

    public List<SolicitudResponse> listarSolicitudesOrdenadas() {
        List<Solicitud> solicitudes = solicitudRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
        return solicitudes.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public String obtenerEstadoSolicitud(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new SolicitudNotFoundException(id));
        return solicitud.getEstado();
    }

    private SolicitudResponse mapToResponse(Solicitud solicitud) {
        return new SolicitudResponse(
                solicitud.getId(),
                solicitud.getEstado(),
                solicitud.getNombre(),
                solicitud.getFechaSolicitud(),
                solicitud.getTema().getNombre(),
                solicitud.getCreatedAt()
        );
    }

    public SolicitudResponse atenderSolicitud(Long id, String nombreTecnico) {
    Solicitud solicitud = solicitudRepository.findById(id)
            .orElseThrow(() -> new SolicitudNotFoundException("Solicitud no encontrada"));

    solicitud.setEstado("ATENDIDA");
    solicitud.setTecnico(nombreTecnico);
    solicitud.setAttendedAt(LocalDateTime.now());

    Solicitud updated = solicitudRepository.save(solicitud);
    return mapToResponse(updated);
}
    
}

package org.factoriaf5.digiital_academy.service;

import org.factoriaf5.digiital_academy.dto.SolicitudRequest;
import org.factoriaf5.digiital_academy.dto.SolicitudResponse;
import org.factoriaf5.digiital_academy.model.Solicitud;
import org.factoriaf5.digiital_academy.model.Tema;
import org.factoriaf5.digiital_academy.repository.SolicitudRepository;
import org.factoriaf5.digiital_academy.repository.TemaRepository;
import org.factoriaf5.digiital_academy.exception.BadRequestException;
import org.factoriaf5.digiital_academy.exception.SolicitudNotFoundException;
import org.factoriaf5.digiital_academy.exception.TemaNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SolicitudServiceTest {

    @Mock
    private SolicitudRepository solicitudRepository;

    @Mock
    private TemaRepository temaRepository;

    @InjectMocks
    private SolicitudService solicitudService;

    private Tema tema;
    private Solicitud solicitud;
    private SolicitudRequest request;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tema = new Tema();
        tema.setId(1L);
        tema.setNombre("Soporte Técnico");

        solicitud = new Solicitud();
        solicitud.setId(1L);
        solicitud.setNombre("Problema impresora");
        solicitud.setFechaSolicitud(LocalDateTime.now());
        solicitud.setTema(tema);
        solicitud.setDescripcion("No imprime");
        solicitud.setEstado("PENDIENTE");
        solicitud.setCreatedAt(LocalDateTime.now());

        request = new SolicitudRequest();
        request.setNombre("Problema impresora");
        request.setDescripcion("No imprime");
        request.setFechaSolicitud(LocalDateTime.now());
        request.setTemaId(1L);
    }

    @Test
    void crearSolicitud_Correctamente() {
        when(temaRepository.findById(1L)).thenReturn(Optional.of(tema));
        when(solicitudRepository.save(any(Solicitud.class))).thenReturn(solicitud);

        SolicitudResponse response = solicitudService.crearSolicitud(request);

        assertNotNull(response);
        assertEquals("Problema impresora", response.getNombre());
        assertEquals("Soporte Técnico", response.getTema());
        verify(solicitudRepository, times(1)).save(any(Solicitud.class));
    }

    @Test
    void crearSolicitud_TemaNoEncontrado() {
        when(temaRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(TemaNotFoundException.class, () -> solicitudService.crearSolicitud(request));
    }

    @Test
    void listarSolicitudesOrdenadas_Correctamente() {
        Solicitud s2 = new Solicitud();
        s2.setId(2L);
        s2.setNombre("Problema PC");
        s2.setFechaSolicitud(LocalDateTime.now());
        s2.setTema(tema);
        s2.setDescripcion("No enciende");
        s2.setEstado("PENDIENTE");
        s2.setCreatedAt(LocalDateTime.now());

        when(solicitudRepository.findAll((Sort) any())).thenReturn(Arrays.asList(solicitud, s2));

        assertEquals(2, solicitudService.listarSolicitudesOrdenadas().size());
        verify(solicitudRepository, times(1)).findAll((Sort) any());
    }

    @Test
    void obtenerEstadoSolicitud_Correctamente() {
        when(solicitudRepository.findById(1L)).thenReturn(Optional.of(solicitud));
        String estado = solicitudService.obtenerEstadoSolicitud(1L);
        assertEquals("PENDIENTE", estado);
    }

    @Test
    void obtenerEstadoSolicitud_NoExiste() {
        when(solicitudRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(SolicitudNotFoundException.class, () -> solicitudService.obtenerEstadoSolicitud(1L));
    }

    @Test
    void atenderSolicitud_Correctamente() {
        when(solicitudRepository.findById(1L)).thenReturn(Optional.of(solicitud));
        when(solicitudRepository.save(any(Solicitud.class))).thenReturn(solicitud);

        SolicitudResponse response = solicitudService.atenderSolicitud(1L, "Técnico 1");

        assertEquals("ATENDIDA", response.getEstado());
        assertEquals("Técnico 1", response.getTecnico());
        assertNotNull(response.getAttendedAt());
    }

    @Test
    void editarSolicitud_Correctamente() {
        SolicitudRequest editRequest = new SolicitudRequest();
        editRequest.setNombre("Problema PC");
        editRequest.setDescripcion("No enciende");
        editRequest.setFechaSolicitud(LocalDateTime.now());
        editRequest.setTemaId(1L);

        when(solicitudRepository.findById(1L)).thenReturn(Optional.of(solicitud));
        when(temaRepository.findById(1L)).thenReturn(Optional.of(tema));
        when(solicitudRepository.save(any(Solicitud.class))).thenReturn(solicitud);

        SolicitudResponse response = solicitudService.editarSolicitud(1L, editRequest);

        assertEquals("Problema PC", response.getNombre());
        assertEquals("Soporte Técnico", response.getTema());
    }

    @Test
    void eliminarSolicitud_Correctamente() {
        solicitud.setEstado("ATENDIDA");
        when(solicitudRepository.findById(1L)).thenReturn(Optional.of(solicitud));
        doNothing().when(solicitudRepository).delete(any(Solicitud.class));

        assertDoesNotThrow(() -> solicitudService.eliminarSolicitud(1L));
        verify(solicitudRepository, times(1)).delete(solicitud);
    }

    @Test
    void eliminarSolicitud_NoAtendida_LanzaExcepcion() {
        solicitud.setEstado("PENDIENTE");
        when(solicitudRepository.findById(1L)).thenReturn(Optional.of(solicitud));

        assertThrows(BadRequestException.class, () -> solicitudService.eliminarSolicitud(1L));
        verify(solicitudRepository, never()).delete(any(Solicitud.class));
    }

    @Test
    void eliminarSolicitud_NoExiste_LanzaExcepcion() {
        when(solicitudRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(SolicitudNotFoundException.class, () -> solicitudService.eliminarSolicitud(1L));
    }
}

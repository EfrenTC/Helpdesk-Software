package org.factoriaf5.digiital_academy.repository;

import org.factoriaf5.digiital_academy.model.Solicitud;
import org.factoriaf5.digiital_academy.model.Tema;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SolicitudRepositoryTest {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void guardarYSolicitarSolicitud_DeberiaFuncionar() {
        String nombreTemaUnico = "Redes_" + System.currentTimeMillis();

        Tema tema = new Tema();
        tema.setNombre(nombreTemaUnico);
        tema = temaRepository.save(tema);

        entityManager.flush();
        entityManager.clear();

        Solicitud solicitud = new Solicitud();
        solicitud.setNombre("Juan Pérez");
        solicitud.setDescripcion("Problema con la impresora");
        solicitud.setFechaSolicitud(LocalDateTime.now());
        solicitud.setEstado("PENDIENTE");
        solicitud.setTema(tema);
        solicitud.setCreatedAt(LocalDateTime.now());

        Solicitud saved = solicitudRepository.save(solicitud);

        assertNotNull(saved.getId(), "El ID no debe ser null");
        assertEquals("Juan Pérez", saved.getNombre());
        assertEquals(nombreTemaUnico, saved.getTema().getNombre());

        Optional<Solicitud> fetched = solicitudRepository.findById(saved.getId());
        assertTrue(fetched.isPresent(), "La solicitud debe existir en la base de datos");
        assertEquals("Juan Pérez", fetched.get().getNombre());
        assertEquals(nombreTemaUnico, fetched.get().getTema().getNombre());
    }
}
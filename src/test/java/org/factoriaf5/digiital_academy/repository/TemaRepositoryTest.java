package org.factoriaf5.digiital_academy.repository;

import org.factoriaf5.digiital_academy.model.Tema;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TemaRepositoryTest {

    @Autowired
    private TemaRepository temaRepository;

    @Test
    void guardarYBuscarTema_DeberiaFuncionar() {

        Tema tema = new Tema();
        tema.setNombre("Soporte Técnico");

        Tema saved = temaRepository.save(tema);

        assertNotNull(saved.getId(), "El ID del tema guardado no debería ser null");

        Optional<Tema> found = temaRepository.findById(saved.getId());
        assertTrue(found.isPresent(), "El tema debería existir en la base de datos");
        assertEquals("Soporte Técnico", found.get().getNombre());

        assertFalse(temaRepository.findAll().isEmpty(), "La lista de temas no debería estar vacía");

        temaRepository.delete(saved);
        assertFalse(temaRepository.findById(saved.getId()).isPresent(), "El tema debería haber sido eliminado");
    }
}

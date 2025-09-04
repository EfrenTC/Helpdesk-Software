package org.factoriaf5.digiital_academy.service;

import org.factoriaf5.digiital_academy.dto.TemaResponse;
import org.factoriaf5.digiital_academy.model.Tema;
import org.factoriaf5.digiital_academy.repository.TemaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TemaServiceTest {

    private TemaRepository temaRepository;
    private TemaService temaService;

    @BeforeEach
    void setUp() {
        temaRepository = mock(TemaRepository.class);
        temaService = new TemaService(temaRepository);
    }

    @Test
    void listarTemas_DeberiaDevolverListaDeTemaResponse() {

        Tema tema1 = new Tema();
        tema1.setId(1L);
        tema1.setNombre("Soporte");

        Tema tema2 = new Tema();
        tema2.setId(2L);
        tema2.setNombre("Desarrollo");

        when(temaRepository.findAll()).thenReturn(Arrays.asList(tema1, tema2));

        List<TemaResponse> response = temaService.listarTemas();

        assertEquals(2, response.size());
        assertEquals("Soporte", response.get(0).getNombre());
        assertEquals(1L, response.get(0).getId());
        assertEquals("Desarrollo", response.get(1).getNombre());
        assertEquals(2L, response.get(1).getId());

        verify(temaRepository, times(1)).findAll();
    }
}

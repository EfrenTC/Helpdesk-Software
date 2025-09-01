package org.factoriaf5.digiital_academy.service;

import org.factoriaf5.digiital_academy.dto.TemaResponse;
import org.factoriaf5.digiital_academy.model.Tema;
import org.factoriaf5.digiital_academy.repository.TemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemaService {

    private final TemaRepository temaRepository;

    public TemaService(TemaRepository temaRepository) {
        this.temaRepository = temaRepository;
    }

    public List<TemaResponse> listarTemas() {
        List<Tema> temas = temaRepository.findAll();
        return temas.stream()
                .map(t -> new TemaResponse(t.getId(), t.getNombre()))
                .collect(Collectors.toList());
    }
}
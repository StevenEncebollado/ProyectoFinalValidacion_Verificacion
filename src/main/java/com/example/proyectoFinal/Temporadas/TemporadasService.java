package com.example.proyectoFinal.Temporadas;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemporadasService {

    private final TemporadasRepository temporadasRepository;

    @Autowired
    public TemporadasService(TemporadasRepository temporadasRepository) {
        this.temporadasRepository = temporadasRepository;
    }

    public List<Temporadas> getAllTemporadas() {
        return temporadasRepository.findAll();
    }

    public Optional<Temporadas> getTemporadaByNombre(String nombre_de_temporada) {
        return temporadasRepository.findById(nombre_de_temporada);
    }

    @Transactional
    public Temporadas createTemporada(Temporadas temporada) {
        if (temporada.getNombre_de_temporada() == null || temporada.getNombre_de_temporada().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la temporada no puede estar vacío");
        }
        return temporadasRepository.save(temporada);
    }
}

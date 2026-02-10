package com.example.proyectoFinal.Escuelas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EscuelasService {

    private final EscuelasRepository repository;

    @Autowired
    public EscuelasService(EscuelasRepository repository) {
        this.repository = repository;
    }

    public List<Escuelas> getAllEscuelas() {
        return repository.findAll();
    }

    public Optional<Escuelas> getEscuelaById(Long id) {
        return repository.findById(id);
    }

    public Escuelas saveEscuela(Escuelas escuela) {
        return repository.save(escuela);
    }
}


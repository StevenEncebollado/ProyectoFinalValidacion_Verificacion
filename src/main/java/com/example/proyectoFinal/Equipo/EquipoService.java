package com.example.proyectoFinal.Equipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    private final EquipoRepository repository;

    @Autowired
    public EquipoService(EquipoRepository repository) {
        this.repository = repository;
    }


    public List<Equipo> getAllEquipos() {
        return repository.findAll();
    }


    public Optional<Equipo> getEquipoById(Long id_equipo) {
        return repository.findById(id_equipo);
    }


    public Equipo saveEquipo(Equipo equipo) {
        return repository.save(equipo);
    }
}

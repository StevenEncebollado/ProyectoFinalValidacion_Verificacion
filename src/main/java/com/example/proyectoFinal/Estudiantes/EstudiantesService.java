package com.example.proyectoFinal.Estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudiantesService {

    private final EstudiantesRepository repository;

    @Autowired
    public EstudiantesService(EstudiantesRepository repository) {
        this.repository = repository;
    }


    public List<Estudiantes> getAllEstudiantes() {
        return repository.findAll();
    }


    public Optional<Estudiantes> getEstudianteById(Long id_estudiante) {
        return repository.findById(id_estudiante);
    }


    public Estudiantes saveEstudiante(Estudiantes estudiante) {
        return repository.save(estudiante);
    }
}

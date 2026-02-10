package com.example.proyectoFinal.Estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudiantesController {

    private final EstudiantesService service;

    @Autowired
    public EstudiantesController(EstudiantesService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Estudiantes>> getAllEstudiantes() {
        List<Estudiantes> estudiantes = service.getAllEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }


    @GetMapping("/{id_estudiante}")
    public ResponseEntity<Estudiantes> getEstudianteById(@PathVariable Long id_estudiante) {
        Optional<Estudiantes> estudiante = service.getEstudianteById(id_estudiante);
        return estudiante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }




    @PostMapping
    public ResponseEntity<?> createEstudiante(@RequestBody Estudiantes estudiante) {
        if (estudiante.getNombre() == null || estudiante.getApellido() == null) {
            return ResponseEntity.badRequest().body("Nombre y Apellido son requeridos");
        }

        Estudiantes saved = service.saveEstudiante(estudiante);
        return ResponseEntity.status(201).body(saved);
    }


}
package com.example.proyectoFinal.Escuelas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/escuelas")
public class EscuelasController {

    private final EscuelasService service;

    @Autowired
    public EscuelasController(EscuelasService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Escuelas>> getAllEscuelas() {
        List<Escuelas> escuelas = service.getAllEscuelas();
        return ResponseEntity.ok(escuelas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escuelas> getEscuelaById(@PathVariable Long id) {
        Optional<Escuelas> escuela = service.getEscuelaById(id);
        return escuela.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Escuelas> createEscuela(@RequestBody Escuelas escuela) {
        Escuelas savedEscuela = service.saveEscuela(escuela);
        return ResponseEntity.ok(savedEscuela);
    }
}

package com.example.proyectoFinal.Entrenadores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadoresController {

    private final EntrenadoresService service;

    @Autowired
    public EntrenadoresController(EntrenadoresService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Entrenadores>> getAllEntrenadores() {
        List<Entrenadores> entrenadores = service.getAllEntrenadores();
        return ResponseEntity.ok(entrenadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenadores> getEntrenadorById(@PathVariable Long id) {
        Optional<Entrenadores> entrenador = service.getEntrenadorById(id);
        return entrenador.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Entrenadores> createEntrenador(@RequestBody Entrenadores entrenador) {
        Entrenadores savedEntrenador = service.saveEntrenador(entrenador);
        return ResponseEntity.ok(savedEntrenador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntrenadorById(@PathVariable Long id) {
        boolean deleted = service.deleteEntrenadorById(id);
        if (deleted) {
            return ResponseEntity.ok("Entrenador con el id: " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("Entrenador con ID " + id + " no encontrado.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenadores> updateEntrenador(
            @PathVariable Long id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String segundoNombre,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) Long numeroDeCelular,
            @RequestParam(required = false) String correoElectronico,
            @RequestParam(required = false) String otrosDetalles) {

        Optional<Entrenadores> entrenador = service.updateEntrenador(
            id,
            nombre,
            segundoNombre,
            apellido,
            numeroDeCelular,
            correoElectronico,
            otrosDetalles
        );
        return entrenador.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
package com.example.proyectoFinal.Temporadas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/temporadas")
public class TemporadasController {

    private final TemporadasService service;

    @Autowired
    public TemporadasController(TemporadasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Temporadas> getAllTemporadas() {
        return service.getAllTemporadas();
    }

    @GetMapping("/{nombre_de_temporada}")
    public ResponseEntity<Temporadas> getTemporadaByNombre(@PathVariable String nombre_de_temporada) {
        Optional<Temporadas> temporada = service.getTemporadaByNombre(nombre_de_temporada);
        return temporada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Temporadas> createTemporada(@RequestBody Temporadas temporada) {
        try {
            Temporadas nuevaTemporada = service.createTemporada(temporada);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTemporada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

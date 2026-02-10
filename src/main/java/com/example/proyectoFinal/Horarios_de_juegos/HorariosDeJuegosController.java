package com.example.proyectoFinal.Horarios_de_juegos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios_de_juegos")
public class HorariosDeJuegosController {

    private final HorariosDeJuegosService service;

    @Autowired
    public HorariosDeJuegosController(HorariosDeJuegosService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Horarios_de_juegos>> getAllHorariosDeJuegos() {
        List<Horarios_de_juegos> horarios = service.getAllHorariosDeJuegos();
        return ResponseEntity.ok(horarios);
    }


    @GetMapping("/{id_juego}")
    public ResponseEntity<Horarios_de_juegos> getHorarioDeJuegoById(@PathVariable Long id_juego) {
        Optional<Horarios_de_juegos> horario = service.getHorarioDeJuegoById(id_juego);
        return horario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Horarios_de_juegos> createHorarioDeJuego(@RequestBody Horarios_de_juegos horarioDeJuego) {
        Horarios_de_juegos savedHorarioDeJuego = service.saveHorarioDeJuego(horarioDeJuego);
        return ResponseEntity.status(201).body(savedHorarioDeJuego);
    }
}
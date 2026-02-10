package com.example.proyectoFinal.Equipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    private final EquipoService service;

    @Autowired
    public EquipoController(EquipoService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Equipo>> getAllEquipos() {
        List<Equipo> equipos = service.getAllEquipos();
        return ResponseEntity.ok(equipos);
    }


    @GetMapping("/{id_equipo}")
    public ResponseEntity<Equipo> getEquipoById(@PathVariable Long id_equipo) {
        Optional<Equipo> equipo = service.getEquipoById(id_equipo);
        return equipo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Equipo> createEquipo(@RequestBody Equipo equipo) {
        Equipo savedEquipo = service.saveEquipo(equipo);
        return ResponseEntity.status(201).body(savedEquipo);
    }
}

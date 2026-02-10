package com.example.proyectoFinal.Ref_Tipos_de_Juegos;

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
@RequestMapping("/api/tipos-de-juegos")
public class RefTiposDeJuegosController {

    private final RefTiposDeJuegosService service;

    @Autowired
    public RefTiposDeJuegosController(RefTiposDeJuegosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Ref_Tipos_de_Juegos>> getAllTiposDeJuegos() {
        List<Ref_Tipos_de_Juegos> tipos = service.getAllTiposDeJuegos();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ref_Tipos_de_Juegos> getTipoDeJuegoById(@PathVariable Long id) {
        Optional<Ref_Tipos_de_Juegos> tipo = service.getTipoDeJuegoById(id);
        return tipo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ref_Tipos_de_Juegos> createTipoDeJuego(@RequestBody Ref_Tipos_de_Juegos tipoDeJuego) {
        Ref_Tipos_de_Juegos savedTipo = service.saveTipoDeJuego(tipoDeJuego);
        return ResponseEntity.ok(savedTipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTipoDeJuegoById(@PathVariable Long id) {
        boolean deleted = service.deleteTipoDeJuegoById(id);
        if (deleted) {
            return ResponseEntity.ok("Tipo de juego con el id:" + id +  " fue eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("Tipo de juego con ID " + id + " no encontrado.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ref_Tipos_de_Juegos> updateTipoDeJuego(
            @PathVariable Long id,
            @RequestParam(required = false) String descripcion_del_tipo_de_juego) {
        Optional<Ref_Tipos_de_Juegos> tipo = service.updateTipoDeJuego(id, descripcion_del_tipo_de_juego);
        return tipo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

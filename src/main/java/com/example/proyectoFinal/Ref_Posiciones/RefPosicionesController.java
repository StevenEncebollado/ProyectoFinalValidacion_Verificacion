package com.example.proyectoFinal.Ref_Posiciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posiciones")
public class RefPosicionesController {

    private final RefPosicionesService service;

    @Autowired
    public RefPosicionesController(RefPosicionesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Ref_Posiciones>> getAllPosiciones() {
        List<Ref_Posiciones> posiciones = service.getAllPosiciones();
        return ResponseEntity.ok(posiciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ref_Posiciones> getPosicionById(@PathVariable Long id) {
        Optional<Ref_Posiciones> posicion = service.getPosicionById(id);
        return posicion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ref_Posiciones> createPosicion(@RequestBody Ref_Posiciones posicion) {
        Ref_Posiciones savedPosicion = service.savePosicion(posicion);
        return ResponseEntity.ok(savedPosicion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePosicionById(@PathVariable Long id) {
        boolean deleted = service.deletePosicionById(id);
        if (deleted) {
            return ResponseEntity.ok("Posición eliminada con el id: " + id + " fue eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("Posición con ID " + id + " no encontrada.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ref_Posiciones> updatePosicion(
            @PathVariable Long id,
            @RequestParam(required = false) String descripcion_de_la_posicion) {

        Optional<Ref_Posiciones> posicion = service.updatePosicion(id, descripcion_de_la_posicion);
        return posicion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

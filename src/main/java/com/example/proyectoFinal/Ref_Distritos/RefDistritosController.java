package com.example.proyectoFinal.Ref_Distritos;
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
@RequestMapping("/api/distritos")
public class RefDistritosController {

    private final RefDistritosService service;

    @Autowired
    public RefDistritosController(RefDistritosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Ref_Distritos>> getAllDistritos() {
        List<Ref_Distritos> distritos = service.getAllDistritos();
        return ResponseEntity.ok(distritos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ref_Distritos> getDistritoById(@PathVariable Long id) {
        Optional<Ref_Distritos> distrito = service.getDistritoById(id);
        return distrito.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ref_Distritos> createDistrito(@RequestBody Ref_Distritos distrito) {
        Ref_Distritos savedDistrito = service.saveDistrito(distrito);
        return ResponseEntity.ok(savedDistrito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDistritoById(@PathVariable Long id) {
        boolean deleted = service.deleteDistritoById(id);
        if (deleted) {
            return ResponseEntity.ok("Distrito con el id: " + id + " fue eliminado correctamente");
        } else {
            return ResponseEntity.status(404).body("Distrito con ID " + id + " no encontrado.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ref_Distritos> updateDistrito(
            @PathVariable Long id,
            @RequestParam(required = false) String nombre_de_distrito) {
        Optional<Ref_Distritos> distrito = service.updateDistrito(id, nombre_de_distrito);
        return distrito.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}

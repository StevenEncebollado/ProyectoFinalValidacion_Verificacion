package com.example.proyectoFinal.Dirreciones;

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
@RequestMapping("/api/direcciones")
public class DireccionesController {

    private final DireccionesService service;

    @Autowired
    public DireccionesController(DireccionesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Direcciones>> getAllDirecciones() {
        List<Direcciones> direcciones = service.getAllDirecciones();
        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direcciones> getDireccionById(@PathVariable Long id) {
        Optional<Direcciones> direccion = service.getDireccionById(id);
        return direccion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Direcciones> createDireccion(@RequestBody Direcciones direccion) {
        Direcciones savedDireccion = service.saveDireccion(direccion);
        return ResponseEntity.ok(savedDireccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDireccionById(@PathVariable Long id) {
        boolean deleted = service.deleteDireccionById(id);
        if (deleted) {
            return ResponseEntity.ok("Dirección con el id: " + id + " fue eliminada correctamente.");
        } else {
            return ResponseEntity.status(404).body("Dirección con ID " + id + " no encontrada.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direcciones> updateDireccion(
            @PathVariable Long id,
            @RequestParam(required = false) Long linea_1_numero_de_edificio,
            @RequestParam(required = false) Long linea_2_numero_de_calle,
            @RequestParam(required = false) String linea_3_area_de_localidad,
            @RequestParam(required = false) String ciudad,
            @RequestParam(required = false) Long codigo_postal,
            @RequestParam(required = false) String estado_provincia_o_condado,
            @RequestParam(required = false) String pais,
            @RequestParam(required = false) String otros_detalles_de_la_direccion) {

        Optional<Direcciones> direccion = service.updateDireccion(
            id,
            linea_1_numero_de_edificio,
            linea_2_numero_de_calle,
            linea_3_area_de_localidad,
            ciudad,
            codigo_postal,
            estado_provincia_o_condado,
            pais,
            otros_detalles_de_la_direccion
        );
        return direccion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

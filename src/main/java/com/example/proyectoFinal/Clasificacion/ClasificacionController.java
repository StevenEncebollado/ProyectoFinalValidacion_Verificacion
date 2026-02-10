package com.example.proyectoFinal.Clasificacion;

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
@RequestMapping("/api/clasificaciones")
public class ClasificacionController {

    private final ClasificacionService service;

    @Autowired
    public ClasificacionController(ClasificacionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Clasificacion>> getAllClasificaciones() {
        List<Clasificacion> clasificaciones = service.getAllClasificaciones();
        return ResponseEntity.ok(clasificaciones);
    }

    @GetMapping("/{fecha_de_clasificacion}")
    public ResponseEntity<Clasificacion> getClasificacionByFecha(@PathVariable Long fecha_de_clasificacion) {
        Optional<Clasificacion> clasificacion = service.getClasificacionByFecha(fecha_de_clasificacion);
        return clasificacion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clasificacion> createClasificacion(@RequestBody Clasificacion clasificacion) {
        Clasificacion savedClasificacion = service.saveClasificacion(clasificacion);
        return ResponseEntity.ok(savedClasificacion);
    }

    @DeleteMapping("/{fecha_de_clasificacion}")
    public ResponseEntity<String> deleteClasificacionByFecha(@PathVariable Long fecha_de_clasificacion) {
        boolean deleted = service.deleteClasificacionByFecha(fecha_de_clasificacion);
        if (deleted) {
            return ResponseEntity.ok(
                "Clasificación con fecha " + fecha_de_clasificacion +
                " fue eliminada correctamente."
            );
        } else {
            return ResponseEntity.status(404).body(
                "Clasificación con fecha " + fecha_de_clasificacion +
                " no encontrada."
            );
        }
    }

    @PutMapping("/{fecha_de_clasificacion}")
    public ResponseEntity<Clasificacion> updateClasificacion(
            @PathVariable Long fecha_de_clasificacion,
            @RequestParam(required = false) String clasificacion_del_distrito,
            @RequestParam(required = false) String clasificacion_general,
            @RequestParam(required = false) String otros_detalles) {
        Optional<Clasificacion> clasificacion = service.updateClasificacion(
            fecha_de_clasificacion,
            clasificacion_del_distrito,
            clasificacion_general,
            otros_detalles);
        return clasificacion.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

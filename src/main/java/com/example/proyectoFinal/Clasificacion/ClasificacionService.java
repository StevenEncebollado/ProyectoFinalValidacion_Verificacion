package com.example.proyectoFinal.Clasificacion;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasificacionService {

    private final ClasificacionRepository repository;

    @Autowired
    public ClasificacionService(ClasificacionRepository repository) {
        this.repository = repository;
    }

    public List<Clasificacion> getAllClasificaciones() {
        return repository.findAll();
    }

    public Optional<Clasificacion> getClasificacionByFecha(Long fecha_de_clasificacion) {
        return repository.findById(fecha_de_clasificacion);
    }

    public Clasificacion saveClasificacion(Clasificacion clasificacion) {
        return repository.save(clasificacion);
    }

    public boolean deleteClasificacionByFecha(Long fecha_de_clasificacion) {
        if (repository.existsById(fecha_de_clasificacion)) {
            repository.deleteById(fecha_de_clasificacion);
            return true;
        }
        return false;
    }

        public Optional<Clasificacion> updateClasificacion(
            Long fecha_de_clasificacion,
            String clasificacion_del_distrito,
            String clasificacion_general,
            String otros_detalles) {
        return repository.findById(fecha_de_clasificacion)
            .map(existingClasificacion -> {
                if (clasificacion_del_distrito != null && !clasificacion_del_distrito.isEmpty()) {
                    existingClasificacion.setClasificacion_del_distrito(
                        clasificacion_del_distrito
                    );
                }
                if (clasificacion_general != null && !clasificacion_general.isEmpty()) {
                    existingClasificacion.setClasificacion_general(
                        clasificacion_general
                    );
                }
                if (otros_detalles != null && !otros_detalles.isEmpty()) {
                    existingClasificacion.setOtros_detalles(
                        otros_detalles
                    );
                }
                return repository.save(existingClasificacion);
            });
    }
}

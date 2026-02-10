package com.example.proyectoFinal.Dirreciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionesService {

    private final DireccionesRepository repository;

    @Autowired
    public DireccionesService(DireccionesRepository repository) {
        this.repository = repository;
    }

    public List<Direcciones> getAllDirecciones() {
        return repository.findAll();
    }

    public Optional<Direcciones> getDireccionById(Long id) {
        return repository.findById(id);
    }

    public Direcciones saveDireccion(Direcciones direccion) {
        return repository.save(direccion);
    }

    public boolean deleteDireccionById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

        public Optional<Direcciones> updateDireccion(
            Long id,
            Long linea1,
            Long linea2,
            String area,
            String ciudad,
            Long codigoPostal,
            String estado,
            String pais,
            String otrosDetalles) {
        return repository.findById(id)
            .map(existingDireccion -> {
                if (linea1 != null) {
                    existingDireccion.setLinea_1_numero_de_edificio(linea1);
                }
                if (linea2 != null) {
                    existingDireccion.setLinea_2_numero_de_calle(linea2);
                }
                if (area != null && !area.isEmpty()) {
                    existingDireccion.setLinea_3_area_de_localidad(area);
                }
                if (ciudad != null && !ciudad.isEmpty()) {
                    existingDireccion.setCiudad(ciudad);
                }
                if (codigoPostal != null) {
                    existingDireccion.setCodigo_postal(codigoPostal);
                }
                if (estado != null && !estado.isEmpty()) {
                    existingDireccion.setEstado_provincia_o_condado(
                        estado
                    );
                }
                if (pais != null && !pais.isEmpty()) {
                    existingDireccion.setPais(pais);
                }
                if (otrosDetalles != null && !otrosDetalles.isEmpty()) {
                    existingDireccion.setOtros_detalles_de_la_direccion(
                        otrosDetalles
                    );
                }
                return repository.save(existingDireccion);
            });
    }
}

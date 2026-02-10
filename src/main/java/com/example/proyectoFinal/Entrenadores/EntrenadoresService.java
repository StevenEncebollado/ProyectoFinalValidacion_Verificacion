package com.example.proyectoFinal.Entrenadores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenadoresService {

    private final EntrenadoresRepository repository;

    @Autowired
    public EntrenadoresService(EntrenadoresRepository repository) {
        this.repository = repository;
    }

    public List<Entrenadores> getAllEntrenadores() {
        return repository.findAll();
    }

    public Optional<Entrenadores> getEntrenadorById(Long id) {
        return repository.findById(id);
    }

    public Entrenadores saveEntrenador(Entrenadores entrenador) {
        return repository.save(entrenador);
    }

    public boolean deleteEntrenadorById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

        public Optional<Entrenadores> updateEntrenador(
            Long id,
            String nombre,
            String segundoNombre,
            String apellido,
            Long numeroDeCelular,
            String correoElectronico,
            String otrosDetalles) {
        return repository.findById(id)
            .map(existingEntrenador -> {
                if (nombre != null && !nombre.isEmpty()) {
                    existingEntrenador.setNombre(nombre);
                }
                if (segundoNombre != null && !segundoNombre.isEmpty()) {
                    existingEntrenador.setSegundo_nombre(segundoNombre);
                }
                if (apellido != null && !apellido.isEmpty()) {
                    existingEntrenador.setApellido(apellido);
                }
                if (numeroDeCelular != null) {
                    existingEntrenador.setNumero_de_celular(numeroDeCelular);
                }
                if (correoElectronico != null && !correoElectronico.isEmpty()) {
                    existingEntrenador.setCorreo_electronico(correoElectronico);
                }
                if (otrosDetalles != null && !otrosDetalles.isEmpty()) {
                    existingEntrenador.setOtros_detalles(
                        otrosDetalles
                    );
                }
                return repository.save(existingEntrenador);
            });
    }
}
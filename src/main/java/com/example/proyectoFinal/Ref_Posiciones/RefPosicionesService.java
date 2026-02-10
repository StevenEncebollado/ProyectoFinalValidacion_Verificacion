package com.example.proyectoFinal.Ref_Posiciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RefPosicionesService {

    private final RefPosicionesRepository repository;

    @Autowired
    public RefPosicionesService(RefPosicionesRepository repository) {
        this.repository = repository;
    }

    public List<Ref_Posiciones> getAllPosiciones() {
        return repository.findAll();
    }

    public Optional<Ref_Posiciones> getPosicionById(Long id) {
        return repository.findById(id);
    }

    public Ref_Posiciones savePosicion(Ref_Posiciones posicion) {
        return repository.save(posicion);
    }

    public boolean deletePosicionById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Ref_Posiciones> updatePosicion(Long id, String descripcion) {
        return repository.findById(id).map(existingPosicion -> {
            if (descripcion != null && !descripcion.isEmpty()) {
                existingPosicion.setDescripcion_de_la_posicion(descripcion);
            }
            return repository.save(existingPosicion);
        });
    }
}

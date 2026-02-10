package com.example.proyectoFinal.Ref_Tipos_de_Juegos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RefTiposDeJuegosService {

    private final RefTiposDeJuegosRepository repository;

    @Autowired
    public RefTiposDeJuegosService(RefTiposDeJuegosRepository repository) {
        this.repository = repository;
    }

    public List<Ref_Tipos_de_Juegos> getAllTiposDeJuegos() {
        return repository.findAll();
    }

    public Optional<Ref_Tipos_de_Juegos> getTipoDeJuegoById(Long id) {
        return repository.findById(id);
    }

    public Ref_Tipos_de_Juegos saveTipoDeJuego(Ref_Tipos_de_Juegos tipoDeJuego) {
        return repository.save(tipoDeJuego);
    }

    public boolean deleteTipoDeJuegoById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Ref_Tipos_de_Juegos> updateTipoDeJuego(Long id, String descripcion) {
        return repository.findById(id).map(existingTipo -> {
            if (descripcion != null && !descripcion.isEmpty()) {
                existingTipo.setDescripcion_del_tipo_de_juego(descripcion);
            }
            return repository.save(existingTipo);
        });
    }
}

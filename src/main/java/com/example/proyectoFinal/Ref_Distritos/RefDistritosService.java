package com.example.proyectoFinal.Ref_Distritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RefDistritosService {

    private final RefDistritosRepository repository;

    @Autowired
    public RefDistritosService(RefDistritosRepository repository) {
        this.repository = repository;
    }

    public List<Ref_Distritos> getAllDistritos() {
        return repository.findAll();
    }

    public Optional<Ref_Distritos> getDistritoById(Long id) {
        return repository.findById(id);
    }


    public Ref_Distritos saveDistrito(Ref_Distritos distrito) {
        return repository.save(distrito);
    }

    public boolean deleteDistritoById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Ref_Distritos> updateDistrito(Long id, String nombreDistrito) {
        return repository.findById(id).map(existingDistrito -> {
            if (nombreDistrito != null && !nombreDistrito.isEmpty()) {
                existingDistrito.setNombre_de_distrito(nombreDistrito);
            }
            return repository.save(existingDistrito);
        });
    }
}
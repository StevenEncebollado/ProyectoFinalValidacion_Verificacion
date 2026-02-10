package com.example.proyectoFinal.Horarios_de_juegos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorariosDeJuegosService {

    private final HorariosDeJuegosRepository repository;

    @Autowired
    public HorariosDeJuegosService(HorariosDeJuegosRepository repository) {
        this.repository = repository;
    }


    public List<Horarios_de_juegos> getAllHorariosDeJuegos() {
        return repository.findAll();
    }


    public Optional<Horarios_de_juegos> getHorarioDeJuegoById(Long id_juego) {
        return repository.findById(id_juego);
    }


    public Horarios_de_juegos saveHorarioDeJuego(Horarios_de_juegos horarioDeJuego) {
        return repository.save(horarioDeJuego);
    }
}

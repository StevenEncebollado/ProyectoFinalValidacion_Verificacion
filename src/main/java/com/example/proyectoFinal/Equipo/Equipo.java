package com.example.proyectoFinal.Equipo;

import jakarta.persistence.*;

@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_equipo;
    private Long id_juego;
    private Long id_estudiante;
    private Long codigo_posicion;
    private Boolean titular;

    public Equipo() {
    }

    public Equipo(Long id_equipo, Long id_juego, Long id_estudiante, Long codigo_posicion, Boolean titular) {
        this.id_equipo = id_equipo;
        this.id_juego = id_juego;
        this.id_estudiante = id_estudiante;
        this.codigo_posicion = codigo_posicion;
        this.titular = titular;
    }

    public Equipo(Long id_juego, Long id_estudiante, Long codigo_posicion, Boolean titular) {
        this.id_juego = id_juego;
        this.id_estudiante = id_estudiante;
        this.codigo_posicion = codigo_posicion;
        this.titular = titular;
    }

    public Long getId_equipo() {
        return id_equipo;
    }

    public Long getId_juego() {
        return id_juego;
    }

    public Long getId_estudiante() {
        return id_estudiante;
    }

    public Long getCodigo_posicion() {
        return codigo_posicion;
    }

    public Boolean getTitular() {
        return titular;
    }

    public void setId_equipo(Long id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setId_juego(Long id_juego) {
        this.id_juego = id_juego;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public void setCodigo_posicion(Long codigo_posicion) {
        this.codigo_posicion = codigo_posicion;
    }

    public void setTitular(Boolean titular) {
        this.titular = titular;
    }
}

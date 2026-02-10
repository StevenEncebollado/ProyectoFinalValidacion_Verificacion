package com.example.proyectoFinal.Horarios_de_juegos;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "horarios_de_juegos")
public class Horarios_de_juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_juego;
    private Long codigo_de_tipo_de_juego;
    private Long id_escuela;
    private String nombre_de_la_escuela_oponente;
    private LocalDateTime fecha_hora_del_juego;
    private String resultado_del_juego;
    private String otros_detalles_del_estudiante;

    public Horarios_de_juegos() {
    }

        public Horarios_de_juegos(
            Long id_juego,
            Long codigo_de_tipo_de_juego,
            Long id_escuela,
            String nombre_de_la_escuela_oponente,
            LocalDateTime fecha_hora_del_juego,
            String resultado_del_juego,
            String otros_detalles_del_estudiante) {
        this.id_juego = id_juego;
        this.codigo_de_tipo_de_juego = codigo_de_tipo_de_juego;
        this.id_escuela = id_escuela;
        this.nombre_de_la_escuela_oponente = nombre_de_la_escuela_oponente;
        this.fecha_hora_del_juego = fecha_hora_del_juego;
        this.resultado_del_juego = resultado_del_juego;
        this.otros_detalles_del_estudiante = otros_detalles_del_estudiante;
    }

        public Horarios_de_juegos(
            Long codigo_de_tipo_de_juego,
            Long id_escuela,
            String nombre_de_la_escuela_oponente,
            LocalDateTime fecha_hora_del_juego,
            String resultado_del_juego,
            String otros_detalles_del_estudiante) {
        this.codigo_de_tipo_de_juego = codigo_de_tipo_de_juego;
        this.id_escuela = id_escuela;
        this.nombre_de_la_escuela_oponente = nombre_de_la_escuela_oponente;
        this.fecha_hora_del_juego = fecha_hora_del_juego;
        this.resultado_del_juego = resultado_del_juego;
        this.otros_detalles_del_estudiante = otros_detalles_del_estudiante;
    }

    public Long getId_juego() {
        return id_juego;
    }

    public Long getCodigo_de_tipo_de_juego() {
        return codigo_de_tipo_de_juego;
    }

    public Long getId_escuela() {
        return id_escuela;
    }

    public String getNombre_de_la_escuela_oponente() {
        return nombre_de_la_escuela_oponente;
    }

    public LocalDateTime getFecha_hora_del_juego() {
        return fecha_hora_del_juego;
    }

    public String getResultado_del_juego() {
        return resultado_del_juego;
    }

    public String getOtros_detalles_del_estudiante() {
        return otros_detalles_del_estudiante;
    }

    public void setId_juego(Long id_juego) {
        this.id_juego = id_juego;
    }

    public void setCodigo_de_tipo_de_juego(Long codigo_de_tipo_de_juego) {
        this.codigo_de_tipo_de_juego = codigo_de_tipo_de_juego;
    }

    public void setId_escuela(Long id_escuela) {
        this.id_escuela = id_escuela;
    }

    public void setNombre_de_la_escuela_oponente(String nombre_de_la_escuela_oponente) {
        this.nombre_de_la_escuela_oponente = nombre_de_la_escuela_oponente;
    }

    public void setFecha_hora_del_juego(LocalDateTime fecha_hora_del_juego) {
        this.fecha_hora_del_juego = fecha_hora_del_juego;
    }

    public void setResultado_del_juego(String resultado_del_juego) {
        this.resultado_del_juego = resultado_del_juego;
    }

    public void setOtros_detalles_del_estudiante(String otros_detalles_del_estudiante) {
        this.otros_detalles_del_estudiante = otros_detalles_del_estudiante;
    }
}

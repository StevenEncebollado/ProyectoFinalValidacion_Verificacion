package com.example.proyectoFinal.Temporadas;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "temporadas")
public class Temporadas {

    @Id
    private String nombre_de_temporada;
    private Long id_escuela;
    private LocalDate fecha_de_inicio;
    private LocalDate fecha_de_finalizacion;
    private String clasificacion_al_final_de_temporada;

    public Temporadas() { }

        public Temporadas(
            String nombre_de_temporada,
            Long id_escuela,
            LocalDate fecha_de_inicio,
            LocalDate fecha_de_finalizacion,
            String clasificacion_al_final_de_temporada) {
        this.nombre_de_temporada = nombre_de_temporada;
        this.id_escuela = id_escuela;
        this.fecha_de_inicio = fecha_de_inicio;
        this.fecha_de_finalizacion = fecha_de_finalizacion;
        this.clasificacion_al_final_de_temporada = clasificacion_al_final_de_temporada;
    }


    public String getNombre_de_temporada() {
        return nombre_de_temporada;
    }

    public Long getId_escuela() {
        return id_escuela;
    }

    public LocalDate getFecha_de_inicio() {
        return fecha_de_inicio;
    }

    public LocalDate getFecha_de_finalizacion() {
        return fecha_de_finalizacion;
    }

    public String getClasificacion_al_final_de_temporada() {
        return clasificacion_al_final_de_temporada;
    }


    public void setNombre_de_temporada(String nombre_de_temporada) {
        this.nombre_de_temporada = nombre_de_temporada;
    }

    public void setId_escuela(Long id_escuela) {
        this.id_escuela = id_escuela;
    }

    public void setFecha_de_inicio(LocalDate fecha_de_inicio) {
        this.fecha_de_inicio = fecha_de_inicio;
    }

    public void setFecha_de_finalizacion(LocalDate fecha_de_finalizacion) {
        this.fecha_de_finalizacion = fecha_de_finalizacion;
    }

    public void setClasificacion_al_final_de_temporada(String clasificacion_al_final_de_temporada) {
        this.clasificacion_al_final_de_temporada = clasificacion_al_final_de_temporada;
    }
}

package com.example.proyectoFinal.Clasificacion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clasificacion")
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fecha_de_clasificacion;
    private Long id_escuela;
    private String clasificacion_del_distrito;
    private String clasificacion_general;
    private String otros_detalles;


    public Clasificacion() {
    }

    public Clasificacion(
            Long id_escuela,
            Long fecha_de_clasificacion,
            String clasificacion_del_distrito,
            String clasificacion_general,
            String otros_detalles) {
        this.id_escuela = id_escuela;
        this.fecha_de_clasificacion = fecha_de_clasificacion;
        this.clasificacion_del_distrito = clasificacion_del_distrito;
        this.clasificacion_general = clasificacion_general;
        this.otros_detalles = otros_detalles;
    }

    public Clasificacion(
            Long id_escuela,
            String clasificacion_del_distrito,
            String clasificacion_general,
            String otros_detalles) {
        this.id_escuela = id_escuela;
        this.clasificacion_del_distrito = clasificacion_del_distrito;
        this.clasificacion_general = clasificacion_general;
        this.otros_detalles = otros_detalles;
    }

    public Long getId_escuela() {
        return id_escuela;
    }

    public Long getFecha_de_clasificacion() {
        return fecha_de_clasificacion;
    }

    public String getClasificacion_del_distrito() {
        return clasificacion_del_distrito;
    }

    public String getClasificacion_general() {
        return clasificacion_general;
    }

    public String getOtros_detalles() {
        return otros_detalles;
    }

    public void setId_escuela(Long id_escuela) {
        this.id_escuela = id_escuela;
    }

    public void setFecha_de_clasificacion(Long fecha_de_clasificacion) {
        this.fecha_de_clasificacion = fecha_de_clasificacion;
    }

    public void setClasificacion_del_distrito(String clasificacion_del_distrito) {
        this.clasificacion_del_distrito = clasificacion_del_distrito;
    }

    public void setClasificacion_general(String clasificacion_general) {
        this.clasificacion_general = clasificacion_general;
    }

    public void setOtros_detalles(String otros_detalles) {
        this.otros_detalles = otros_detalles;
    }
}

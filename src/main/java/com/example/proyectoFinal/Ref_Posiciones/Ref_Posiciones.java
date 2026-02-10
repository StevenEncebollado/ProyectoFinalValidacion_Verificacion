package com.example.proyectoFinal.Ref_Posiciones;

import jakarta.persistence.*;

@Entity
@Table(name = "ref_posiciones")
public class Ref_Posiciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_posicion;
    private String descripcion_de_la_posicion;


    public Ref_Posiciones() {
    }

    public Ref_Posiciones(Long codigo_posicion, String descripcion_de_la_posicion) {
        this.codigo_posicion = codigo_posicion;
        this.descripcion_de_la_posicion = descripcion_de_la_posicion;
    }

    public Ref_Posiciones(String descripcion_de_la_posicion) {
        this.descripcion_de_la_posicion = descripcion_de_la_posicion;
    }

    public Long getCodigo_posicion() {
        return codigo_posicion;
    }

    public String getDescripcion_de_la_posicion() {
        return descripcion_de_la_posicion;
    }

    public void setCodigo_posicion(Long codigo_posicion) {
        this.codigo_posicion = codigo_posicion;
    }

    public void setDescripcion_de_la_posicion(String descripcion_de_la_posicion) {
        this.descripcion_de_la_posicion = descripcion_de_la_posicion;
    }
}

package com.example.proyectoFinal.Ref_Tipos_de_Juegos;

import jakarta.persistence.*;

@Entity
@Table(name = "ref_tipos_de_juegos")
public class Ref_Tipos_de_Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_de_tipo_de_juego;
    private String descripcion_del_tipo_de_juego;


    public Ref_Tipos_de_Juegos() {
    }

    public Ref_Tipos_de_Juegos(Long codigo_de_tipo_de_juego, String descripcion_del_tipo_de_juego) {
        this.codigo_de_tipo_de_juego = codigo_de_tipo_de_juego;
        this.descripcion_del_tipo_de_juego = descripcion_del_tipo_de_juego;
    }

    public Ref_Tipos_de_Juegos(String descripcion_del_tipo_de_juego) {
        this.descripcion_del_tipo_de_juego = descripcion_del_tipo_de_juego;
    }

    public Long getCodigo_de_tipo_de_juego() {
        return codigo_de_tipo_de_juego;
    }

    public String getDescripcion_del_tipo_de_juego() {
        return descripcion_del_tipo_de_juego;
    }

    public void setCodigo_de_tipo_de_juego(Long codigo_de_tipo_de_juego) {
        this.codigo_de_tipo_de_juego = codigo_de_tipo_de_juego;
    }

    public void setDescripcion_del_tipo_de_juego(String descripcion_del_tipo_de_juego) {
        this.descripcion_del_tipo_de_juego = descripcion_del_tipo_de_juego;
    }
}

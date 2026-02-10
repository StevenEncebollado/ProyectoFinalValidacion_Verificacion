package com.example.proyectoFinal.Ref_Distritos;


import jakarta.persistence.*;

@Entity
@Table(name = "ref_distritos")
public class Ref_Distritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_de_distrito;
    private String nombre_de_distrito;


    public Ref_Distritos() {
    }

    public Ref_Distritos(Long codigo_de_distrito, String nombre_de_distrito) {
        this.codigo_de_distrito = codigo_de_distrito;
        this.nombre_de_distrito = nombre_de_distrito;
    }

    public Ref_Distritos(String nombre_de_distrito) {
        this.nombre_de_distrito = nombre_de_distrito;
    }

    public Long getCodigo_de_distrito() {
        return codigo_de_distrito;
    }

    public String getNombre_de_distrito() {
        return nombre_de_distrito;
    }

    public void setCodigo_de_distrito(Long codigo_de_distrito) {
        this.codigo_de_distrito = codigo_de_distrito;
    }

    public void setNombre_de_distrito(String nombre_de_distrito) {
        this.nombre_de_distrito = nombre_de_distrito;
    }
}

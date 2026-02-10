package com.example.proyectoFinal.Escuelas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "escuelas")
public class Escuelas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_escuela;
    private Long id_del_entrenador_actual;
    private Long codigo_de_distrito;
    private Long id_direccion_escuela;
    private String nombre_de_escuela;
    private String mascota_de_escuela;
    private Long numero_de_telefono;
    private String estadio_local;
    private String otros_detalles;

    public Escuelas() {
    }

        public Escuelas(
            Long id_escuela,
            Long id_del_entrenador_actual,
            Long codigo_de_distrito,
            Long id_direccion_escuela,
            String nombre_de_escuela,
            String mascota_de_escuela,
            Long numero_de_telefono,
            String estadio_local,
            String otros_detalles) {
        this.id_escuela = id_escuela;
        this.id_del_entrenador_actual = id_del_entrenador_actual;
        this.codigo_de_distrito = codigo_de_distrito;
        this.id_direccion_escuela = id_direccion_escuela;
        this.nombre_de_escuela = nombre_de_escuela;
        this.mascota_de_escuela = mascota_de_escuela;
        this.numero_de_telefono = numero_de_telefono;
        this.estadio_local = estadio_local;
        this.otros_detalles = 
            otros_detalles;
    }

        public Escuelas(
            Long id_del_entrenador_actual,
            Long codigo_de_distrito,
            Long id_direccion_escuela,
            String nombre_de_escuela,
            String mascota_de_escuela,
            Long numero_de_telefono,
            String estadio_local,
            String otros_detalles) {
        this.id_del_entrenador_actual = id_del_entrenador_actual;
        this.codigo_de_distrito = codigo_de_distrito;
        this.id_direccion_escuela = id_direccion_escuela;
        this.nombre_de_escuela = nombre_de_escuela;
        this.mascota_de_escuela = mascota_de_escuela;
        this.numero_de_telefono = numero_de_telefono;
        this.estadio_local = estadio_local;
        this.otros_detalles = 
            otros_detalles;
    }

    public Long getId_escuela() {
        return id_escuela;
    }

    public Long getId_del_entrenador_actual() {
        return id_del_entrenador_actual;
    }

    public Long getCodigo_de_distrito() {
        return codigo_de_distrito;
    }

    public Long getId_direccion_escuela() {
        return id_direccion_escuela;
    }

    public String getNombre_de_escuela() {
        return nombre_de_escuela;
    }

    public String getMascota_de_escuela() {
        return mascota_de_escuela;
    }

    public Long getNumero_de_telefono() {
        return numero_de_telefono;
    }

    public String getEstadio_local() {
        return estadio_local;
    }

    public String getOtros_detalles() {
        return otros_detalles;
    }

    public void setId_escuela(Long id_escuela) {
        this.id_escuela = id_escuela;
    }

    public void setId_del_entrenador_actual(Long id_del_entrenador_actual) {
        this.id_del_entrenador_actual = id_del_entrenador_actual;
    }

    public void setCodigo_de_distrito(Long codigo_de_distrito) {
        this.codigo_de_distrito = codigo_de_distrito;
    }

    public void setId_direccion_escuela(Long id_direccion_escuela) {
        this.id_direccion_escuela = id_direccion_escuela;
    }

    public void setNombre_de_escuela(String nombre_de_escuela) {
        this.nombre_de_escuela = nombre_de_escuela;
    }

    public void setMascota_de_escuela(String mascota_de_escuela) {
        this.mascota_de_escuela = mascota_de_escuela;
    }

    public void setNumero_de_telefono(Long numero_de_telefono) {
        this.numero_de_telefono = numero_de_telefono;
    }

    public void setEstadio_local(String estadio_local) {
        this.estadio_local = estadio_local;
    }

    public void setOtros_detalles(String otros_detalles) {
        this.otros_detalles = otros_detalles;
    }
}

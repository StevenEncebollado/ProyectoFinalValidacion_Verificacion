package com.example.proyectoFinal.Entrenadores;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entrenadores")
public class Entrenadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entrenador;
    private Long id_direccion_del_entrenador;
    private String nombre;
    private String segundo_nombre;
    private String apellido;
    private Long numero_de_celular;
    private String correo_electronico;
    private LocalDate fecha_de_inicio;
    private LocalDate fecha_de_finalizacion;
    private String otros_detalles;

    public Entrenadores() {
    }

        public Entrenadores(
            Long id_entrenador,
            Long id_direccion_del_entrenador,
            String nombre,
            String segundo_nombre,
            String apellido,
            Long numero_de_celular,
            String correo_electronico,
            LocalDate fecha_de_inicio,
            LocalDate fecha_de_finalizacion,
            String otros_detalles) {
        this.id_entrenador = id_entrenador;
        this.id_direccion_del_entrenador = id_direccion_del_entrenador;
        this.nombre = nombre;
        this.segundo_nombre = segundo_nombre;
        this.apellido = apellido;
        this.numero_de_celular = numero_de_celular;
        this.correo_electronico = correo_electronico;
        this.fecha_de_inicio = fecha_de_inicio;
        this.fecha_de_finalizacion = fecha_de_finalizacion;
        this.otros_detalles = 
            otros_detalles;
    }

        public Entrenadores(
            Long id_direccion_del_entrenador,
            String nombre,
            String segundo_nombre,
            String apellido,
            Long numero_de_celular,
            String correo_electronico,
            LocalDate fecha_de_inicio,
            LocalDate fecha_de_finalizacion,
            String otros_detalles) {
        this.id_direccion_del_entrenador = id_direccion_del_entrenador;
        this.nombre = nombre;
        this.segundo_nombre = segundo_nombre;
        this.apellido = apellido;
        this.numero_de_celular = numero_de_celular;
        this.correo_electronico = correo_electronico;
        this.fecha_de_inicio = fecha_de_inicio;
        this.fecha_de_finalizacion = fecha_de_finalizacion;
        this.otros_detalles = 
            otros_detalles;
    }

    public Long getId_entrenador() {
        return id_entrenador;
    }

    public Long getId_direccion_del_entrenador() {
        return id_direccion_del_entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Long getNumero_de_celular() {
        return numero_de_celular;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public LocalDate getFecha_de_inicio() {
        return fecha_de_inicio;
    }

    public LocalDate getFecha_de_finalizacion() {
        return fecha_de_finalizacion;
    }

    public String getOtros_detalles() {
        return otros_detalles;
    }

    public void setId_entrenador(Long id_entrenador) {
        this.id_entrenador = id_entrenador;
    }

    public void setId_direccion_del_entrenador(Long id_direccion_del_entrenador) {
        this.id_direccion_del_entrenador = id_direccion_del_entrenador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumero_de_celular(Long numero_de_celular) {
        this.numero_de_celular = numero_de_celular;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setFecha_de_inicio(LocalDate fecha_de_inicio) {
        this.fecha_de_inicio = fecha_de_inicio;
    }

    public void setFecha_de_finalizacion(LocalDate fecha_de_finalizacion) {
        this.fecha_de_finalizacion = fecha_de_finalizacion;
    }

    public void setOtros_detalles(String otros_detalles) {
        this.otros_detalles = otros_detalles;
    }
}

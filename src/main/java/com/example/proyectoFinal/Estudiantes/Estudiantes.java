package com.example.proyectoFinal.Estudiantes;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudiante;
    private Long id_escuela;
    private Long id_direccion_del_estudiante;
    private String nombre;
    private String segundo_nombre;
    private String apellido;
    private Long numero_celular;
    private String correo_electronico;
    private LocalDate fecha_primer_alquiler;
    private LocalDate fecha_de_salida_de_universidad;
    private Double saldo_actual_derivado;
    private String otros_detalles_del_estudiante;


    public Estudiantes() {
    }

        public Estudiantes(
            Long id_estudiante,
            Long id_escuela,
            Long id_direccion_del_estudiante,
            String nombre,
            String segundo_nombre,
            String apellido,
            Long numero_celular,
            String correo_electronico,
            LocalDate fecha_primer_alquiler,
            LocalDate fecha_de_salida_de_universidad,
            Double saldo_actual_derivado,
            String otros_detalles_del_estudiante) {
        this.id_estudiante = id_estudiante;
        this.id_escuela = id_escuela;
        this.id_direccion_del_estudiante = id_direccion_del_estudiante;
        this.nombre = nombre;
        this.segundo_nombre = segundo_nombre;
        this.apellido = apellido;
        this.numero_celular = numero_celular;
        this.correo_electronico = correo_electronico;
        this.fecha_primer_alquiler = fecha_primer_alquiler;
        this.fecha_de_salida_de_universidad = fecha_de_salida_de_universidad;
        this.saldo_actual_derivado = saldo_actual_derivado;
        this.otros_detalles_del_estudiante = 
            otros_detalles_del_estudiante;
    }

        public Estudiantes(
            Long id_escuela,
            Long id_direccion_del_estudiante,
            String nombre,
            String segundo_nombre,
            String apellido,
            Long numero_celular,
            String correo_electronico,
            LocalDate fecha_primer_alquiler,
            LocalDate fecha_de_salida_de_universidad,
            Double saldo_actual_derivado,
            String otros_detalles_del_estudiante) {
        this.id_escuela = id_escuela;
        this.id_direccion_del_estudiante = id_direccion_del_estudiante;
        this.nombre = nombre;
        this.segundo_nombre = segundo_nombre;
        this.apellido = apellido;
        this.numero_celular = numero_celular;
        this.correo_electronico = correo_electronico;
        this.fecha_primer_alquiler = fecha_primer_alquiler;
        this.fecha_de_salida_de_universidad = fecha_de_salida_de_universidad;
        this.saldo_actual_derivado = saldo_actual_derivado;
        this.otros_detalles_del_estudiante = 
            otros_detalles_del_estudiante;
    }

    public Long getId_estudiante() {
        return id_estudiante;
    }

    public Long getId_escuela() {
        return id_escuela;
    }

    public Long getId_direccion_del_estudiante() {
        return id_direccion_del_estudiante;
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

    public Long getNumero_celular() {
        return numero_celular;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public LocalDate getFecha_primer_alquiler() {
        return fecha_primer_alquiler;
    }

    public LocalDate getFecha_de_salida_de_universidad() {
        return fecha_de_salida_de_universidad;
    }

    public Double getSaldo_actual_derivado() {
        return saldo_actual_derivado;
    }

    public String getOtros_detalles_del_estudiante() {
        return otros_detalles_del_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public void setId_escuela(Long id_escuela) {
        this.id_escuela = id_escuela;
    }

    public void setId_direccion_del_estudiante(Long id_direccion_del_estudiante) {
        this.id_direccion_del_estudiante = id_direccion_del_estudiante;
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

    public void setNumero_celular(Long numero_celular) {
        this.numero_celular = numero_celular;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setFecha_primer_alquiler(LocalDate fecha_primer_alquiler) {
        this.fecha_primer_alquiler = fecha_primer_alquiler;
    }

    public void setFecha_de_salida_de_universidad(LocalDate fecha_de_salida_de_universidad) {
        this.fecha_de_salida_de_universidad = fecha_de_salida_de_universidad;
    }

    public void setSaldo_actual_derivado(Double saldo_actual_derivado) {
        this.saldo_actual_derivado = saldo_actual_derivado;
    }

    public void setOtros_detalles_del_estudiante(String otros_detalles_del_estudiante) {
        this.otros_detalles_del_estudiante = otros_detalles_del_estudiante;
    }
}

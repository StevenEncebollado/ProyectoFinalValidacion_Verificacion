package com.example.proyectoFinal.Dirreciones;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direcciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_direccion;
    private Long linea_1_numero_de_edificio;
    private Long linea_2_numero_de_calle;
    private String linea_3_area_de_localidad;
    private String ciudad;
    private Long codigo_postal;
    private String estado_provincia_o_condado;
    private String pais;
    private String otros_detalles_de_la_direccion;

    public Direcciones() {
    }

        public Direcciones(
            Long id_direccion,
            Long linea_1_numero_de_edificio,
            Long linea_2_numero_de_calle,
            String linea_3_area_de_localidad,
            String ciudad,
            Long codigo_postal,
            String estado_provincia_o_condado,
            String pais,
            String otros_detalles_de_la_direccion) {
        this.id_direccion = id_direccion;
        this.linea_1_numero_de_edificio = linea_1_numero_de_edificio;
        this.linea_2_numero_de_calle = linea_2_numero_de_calle;
        this.linea_3_area_de_localidad = linea_3_area_de_localidad;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.estado_provincia_o_condado = estado_provincia_o_condado;
        this.pais = pais;
        this.otros_detalles_de_la_direccion = 
            otros_detalles_de_la_direccion;
    }

        public Direcciones(
            Long linea_1_numero_de_edificio,
            Long linea_2_numero_de_calle,
            String linea_3_area_de_localidad,
            String ciudad,
            Long codigo_postal,
            String estado_provincia_o_condado,
            String pais,
            String otros_detalles_de_la_direccion) {
        this.linea_1_numero_de_edificio = linea_1_numero_de_edificio;
        this.linea_2_numero_de_calle = linea_2_numero_de_calle;
        this.linea_3_area_de_localidad = linea_3_area_de_localidad;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.estado_provincia_o_condado = estado_provincia_o_condado;
        this.pais = pais;
        this.otros_detalles_de_la_direccion = 
            otros_detalles_de_la_direccion;
    }

    public Long getId_direccion() {
        return id_direccion;
    }

    public Long getLinea_1_numero_de_edificio() {
        return linea_1_numero_de_edificio;
    }

    public Long getLinea_2_numero_de_calle() {
        return linea_2_numero_de_calle;
    }

    public String getLinea_3_area_de_localidad() {
        return linea_3_area_de_localidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Long getCodigo_postal() {
        return codigo_postal;
    }

    public String getEstado_provincia_o_condado() {
        return estado_provincia_o_condado;
    }

    public String getPais() {
        return pais;
    }

    public String getOtros_detalles_de_la_direccion() {
        return otros_detalles_de_la_direccion;
    }

    public void setId_direccion(Long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public void setLinea_1_numero_de_edificio(Long linea_1_numero_de_edificio) {
        this.linea_1_numero_de_edificio = linea_1_numero_de_edificio;
    }

    public void setLinea_2_numero_de_calle(Long linea_2_numero_de_calle) {
        this.linea_2_numero_de_calle = linea_2_numero_de_calle;
    }

    public void setLinea_3_area_de_localidad(String linea_3_area_de_localidad) {
        this.linea_3_area_de_localidad = linea_3_area_de_localidad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCodigo_postal(Long codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setEstado_provincia_o_condado(String estado_provincia_o_condado) {
        this.estado_provincia_o_condado = estado_provincia_o_condado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setOtros_detalles_de_la_direccion(String otros_detalles_de_la_direccion) {
        this.otros_detalles_de_la_direccion = otros_detalles_de_la_direccion;
    }
}

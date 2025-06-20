package com.duoc.backend.Comisaria;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Comisaria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idComisaria;
    private String nombre;
    private String ubicacion;

    // Getters and Setters
    public Long getIdComisaria() {
        return idComisaria;
    }

    public void setIdComisaria(Long idComisaria) {
        this.idComisaria = idComisaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion(String ubicacion){
        return ubicacion;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
}

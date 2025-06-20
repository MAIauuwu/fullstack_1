package com.duoc.backend.Comisaria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comisaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getUbicacion(){
        return ubicacion;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
}

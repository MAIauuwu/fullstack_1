package com.duoc.backend.TipoDeUsuario;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo usuarios")

public class TipoDeUsuario {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_TipoDeUsuario;
    private String tipoUsuario;
    private String descripcion;
    public TipoDeUsuario() {
    }
    public TipoDeUsuario(String tipoUsuario, String descripcion) {
        this.tipoUsuario = tipoUsuario;
        this.descripcion = descripcion;
    }



    // Getters and Setters
    public Long getId_TipoDeUsuario() {
        return id_TipoDeUsuario;
    }

    public void setId_TipoDeUsuario(Long id_TipoDeUsuario) {
        this.id_TipoDeUsuario = id_TipoDeUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoDeUsuario{" +
                "id=" + id_TipoDeUsuario +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}

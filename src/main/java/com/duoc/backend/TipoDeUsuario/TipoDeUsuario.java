package com.duoc.backend.TipoDeUsuario;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_usuario")

public class TipoDeUsuario {

    public Long getidTipoDeUsuario;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTipoDeUsuario;
    private String tipoUsuario;
    private String descripcion;
    public TipoDeUsuario() {
    }
    public TipoDeUsuario(String tipoUsuario, String descripcion) {
        this.tipoUsuario = tipoUsuario;
        this.descripcion = descripcion;
    }



    // Getters and Setters
    public Long getIdTipoDeUsuario() {
        return idTipoDeUsuario;
    }

    public void setIdTipoDeUsuario(Long idTipoDeUsuario) {
        this.idTipoDeUsuario = idTipoDeUsuario;
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
                "id=" + idTipoDeUsuario +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}

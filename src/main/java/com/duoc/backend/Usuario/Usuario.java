package com.duoc.backend.Usuario;

import com.duoc.backend.TipoDeUsuario.TipoDeUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_tipo_de_usuario", nullable = false)
    private TipoDeUsuario tipoDeUsuario;

    public Usuario() {}


    public Usuario(String nombre, TipoDeUsuario tipoDeUsuario) {
        this.nombre = nombre;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDeUsuario getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
}

package com.duoc.backend.TipoDeUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoDeUsuarioController {

    @Autowired
    private TipoDeUsuarioRepository tipoDeUsuarioRepository;

    public Iterable<TipoDeUsuario> getAllTipoDeUsuario() {
        return tipoDeUsuarioRepository.findAll();
    }

    public TipoDeUsuario getTipoDeUsuarioById(Long id_TipoDeUsuario) {
        return tipoDeUsuarioRepository.findById(id_TipoDeUsuario).orElse(null);
    }
    @PostMapping
    public TipoDeUsuario saveTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        return tipoDeUsuarioRepository.save(tipoDeUsuario);
    }
    @DeleteMapping("/{id}")
    public void deleteTipoDeUsuario(Long id_TipoDeUsuario) {
        tipoDeUsuarioRepository.deleteById(id_TipoDeUsuario);
    }
}

package com.duoc.backend.TipoDeUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDeUsuarioService {

    @Autowired
    private TipoDeUsuarioRepository tipoDeUsuarioRepository;

    public Iterable<TipoDeUsuario> getAllTipoDeUsuario() {
        return tipoDeUsuarioRepository.findAll();
    }

    public TipoDeUsuario getTipoDeUsuarioById(Long id_TipoDeUsuario) {
        return tipoDeUsuarioRepository.findById(id_TipoDeUsuario).orElse(null);
    }

    public TipoDeUsuario saveTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        return tipoDeUsuarioRepository.save(tipoDeUsuario);
    }

    public void deleteTipoDeUsuario(Long id_TipoDeUsuario) {
        tipoDeUsuarioRepository.deleteById(id_TipoDeUsuario);
    }
}
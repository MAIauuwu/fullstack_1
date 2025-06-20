package com.duoc.backend.TipoDeUsuario;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeUsuarioRepository extends CrudRepository<TipoDeUsuario, Long> {
    }


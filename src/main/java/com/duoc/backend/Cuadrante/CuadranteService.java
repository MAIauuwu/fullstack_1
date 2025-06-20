package com.duoc.backend.Cuadrante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class CuadranteService {

    @Autowired
    private CuadranteRepository cuadranteRepository;

    public Iterable<Cuadrante> getAllCuadrante() {
        return cuadranteRepository.findAll();
    }

    public Cuadrante getCuadranteById(Long id) {
        return cuadranteRepository.findById(id).orElse(null);
    }

    public Cuadrante saveCuadrante(Cuadrante cuadrante) {
        return cuadranteRepository.save(cuadrante);
    }

    public void deleteCuadrante(Long id) {
        cuadranteRepository.deleteById(id);
    }
}
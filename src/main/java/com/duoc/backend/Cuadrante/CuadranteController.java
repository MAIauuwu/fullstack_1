package com.duoc.backend.Cuadrante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cuadrante")
public class CuadranteController {

    @Autowired
    private CuadranteService cuadranteService;
    @GetMapping
    public List<Cuadrante> getAllcuadrantes() {
        return (List<Cuadrante>) cuadranteService.getAllCuadrante();
    }

    @GetMapping("/{id}")
    public Cuadrante getCuadranteById(@PathVariable Long id) {
        return cuadranteService.getCuadranteById(id);
    }

    @PostMapping("/guardar")
    public Cuadrante saveCuadrante(@RequestBody Cuadrante cuadrante) {
        return cuadranteService.saveCuadrante(cuadrante);
    }

   @PutMapping("/{id}")
    public Cuadrante updateCuadrante(@PathVariable Long id, @RequestBody Cuadrante cuadrante) {
    cuadrante.setId(id);
    return cuadranteService.saveCuadrante(cuadrante);
}
    @DeleteMapping("/{id}")
    public void deleteCuadrante(@PathVariable Long id) {
        cuadranteService.deleteCuadrante(id);
    }
    
}





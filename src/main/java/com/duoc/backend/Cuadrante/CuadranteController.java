package com.duoc.backend.Cuadrante;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cuadrante")
public class CuadranteController {

    @Autowired
    private CuadranteService cuadranteService;
    @Autowired
    private CuadranteModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Cuadrante>> getAllcuadrantes(){
        List<EntityModel<Cuadrante>> modelos = new ArrayList<>();
        cuadranteService.getAllCuadrante()
                .forEach(cuadrante -> modelos.add(assembler.toModel(cuadrante)));

        return CollectionModel.of(modelos,
                linkTo(methodOn(CuadranteController.class).getAllcuadrantes()).withSelfRel());
    }



    @GetMapping("/{id}")
    public EntityModel<Cuadrante> getCuadranteById(@PathVariable Long id) {
    Cuadrante cuadrante = cuadranteService.getCuadranteById(id);
    return assembler.toModel(cuadrante);
    }

    @PostMapping("/guardar")
    public EntityModel<Cuadrante> saveCuadrante(@RequestBody Cuadrante cuadrante) {
        Cuadrante guardar = cuadranteService.saveCuadrante(cuadrante);
        return assembler.toModel(guardar);
    }

   @PutMapping("/{id}")
    public EntityModel<Cuadrante> updateCuadrante(@PathVariable Long id, @RequestBody Cuadrante cuadrante) {
    cuadrante.setId(id);
    Cuadrante updated = cuadranteService.saveCuadrante(cuadrante);
    return assembler.toModel(updated);
    }
    @DeleteMapping("/{id}")
    public void deleteCuadrante(@PathVariable Long id) {
        cuadranteService.deleteCuadrante(id);
    }
    
}





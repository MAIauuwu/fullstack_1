package com.duoc.backend.TipoDeUsuario;

import com.duoc.backend.Comisaria.Comisaria;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.BooleanUtils.forEach;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/tipos")
public class TipoDeUsuarioController {

    @Autowired
    private TipoDeUsuarioRepository tipoDeUsuarioRepository;
    @Autowired
    private TipoDeUsuarioModelAssembler assembler;
    @GetMapping
    public CollectionModel<EntityModel<TipoDeUsuario>> getAllTipoDeUsuario() {
        List<EntityModel<TipoDeUsuario>> tipoDeUsuarioModel = new ArrayList<>();
        tipoDeUsuarioRepository.findAll()
        .forEach(tipoDeUsuario -> {
            EntityModel<TipoDeUsuario> tipoDeUsuarioEntityModel = assembler.toModel(tipoDeUsuario);
            tipoDeUsuarioModel.add(tipoDeUsuarioEntityModel);
        });
            return CollectionModel.of(tipoDeUsuarioModel,
                    linkTo(methodOn(TipoDeUsuarioController.class).getAllTipoDeUsuario()).withSelfRel()
        );

    }
    @GetMapping("/{id")
    public ResponseEntity<EntityModel<TipoDeUsuario>> getTipoDeUsuarioById(@PathVariable Long id_TipoDeUsuario) {
        Optional<TipoDeUsuario> tipoDeUsuarioOptional = tipoDeUsuarioRepository.findById(id_TipoDeUsuario);

        if (tipoDeUsuarioOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(assembler.toModel(tipoDeUsuarioOptional.get()));
        }
    }
    @PostMapping
    public EntityModel<TipoDeUsuario> saveTipoDeUsuario(@PathVariable TipoDeUsuario tipoDeUsuario) {
    TipoDeUsuario guardado = tipoDeUsuarioRepository.save(tipoDeUsuario);
    return assembler.toModel(guardado);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoDeUsuario(@PathVariable Long id_TipoDeUsuario) {
        tipoDeUsuarioRepository.deleteById(id_TipoDeUsuario);
    }
}

package com.duoc.backend.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Usuario>> getAllUsuarios() {
        List<EntityModel<Usuario>> usuarios = new ArrayList<>();
        usuarioService.getAllUsuarios()
                .forEach(usuario -> usuarios.add(assembler.toModel(usuario)));

        return CollectionModel.of(usuarios,
                linkTo(methodOn(UsuarioController.class).getAllUsuarios()).withSelfRel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Usuario>> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(assembler.toModel(usuario));
        }
    }
    @PostMapping
    public ResponseEntity<EntityModel<Usuario>> saveUsuario(@RequestBody Usuario usuario) {
        Usuario saved = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(assembler.toModel(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}


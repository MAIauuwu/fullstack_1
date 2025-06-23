package com.duoc.backend.Mensaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    @Autowired
    private MensajeRepository mensajeRepository;
    @Autowired
    private MensajeModelAssembler assembler;

    @PostMapping
    public ResponseEntity<EntityModel<Mensaje>> crearMensaje(@RequestBody Mensaje dto) {
        dto.setFechaHora(LocalDateTime.now());
        Mensaje guardado = mensajeRepository.save(dto);
        return ResponseEntity
                .created(linkTo(methodOn(MensajeController.class).getMensajeById(guardado.getId())).toUri())
                .body(assembler.toModel(guardado));
    }

    @GetMapping
    public CollectionModel<EntityModel<Mensaje>> getAllMensajes() {
        List<EntityModel<Mensaje>> mensajesModel = new ArrayList<>();

        mensajeRepository.findAll().forEach(mensaje -> {
            EntityModel<Mensaje> mensajeModel = assembler.toModel(mensaje);
            mensajesModel.add(mensajeModel);
        });

        return CollectionModel.of(mensajesModel,
                linkTo(methodOn(MensajeController.class).getAllMensajes()).withSelfRel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Mensaje>> getMensajeById(@PathVariable Long id) {
        return mensajeRepository.findById(id)
                .map(assembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

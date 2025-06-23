package com.duoc.backend.TipoDeUsuario;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TipoDeUsuarioModelAssembler implements RepresentationModelAssembler <TipoDeUsuario, EntityModel<TipoDeUsuario>>{

    @Override
    public EntityModel<TipoDeUsuario> toModel(TipoDeUsuario tipo) {
        return EntityModel.of(tipo,
                linkTo(methodOn(TipoDeUsuarioController.class).getTipoDeUsuarioById(tipo.getidTipoDeUsuario)).withSelfRel(),
                linkTo(methodOn(TipoDeUsuarioController.class).getAllTipoDeUsuario()).withRel("tipos")
        );

    }
}

package com.duoc.backend.Mensaje;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class MensajeModelAssembler implements RepresentationModelAssembler<Mensaje, EntityModel<Mensaje>> {
    @Override
    public EntityModel<Mensaje> toModel(Mensaje mensaje) {
        return EntityModel.of(mensaje,
                linkTo(methodOn(MensajeController.class).getMensajeById(mensaje.getId())).withSelfRel(),
                linkTo(methodOn(MensajeController.class).getAllMensajes()).withRel("mensajes"));
    }

}

package com.duoc.backend.Cuadrante;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CuadranteModelAssembler implements RepresentationModelAssembler<Cuadrante, EntityModel<Cuadrante>> {
    @Override
    public EntityModel<Cuadrante> toModel(Cuadrante cuadrante){
        return EntityModel.of(cuadrante,
                linkTo(methodOn(CuadranteController.class).getCuadranteById(cuadrante.getId())).withSelfRel(),
                linkTo(methodOn(CuadranteController.class).getAllcuadrantes()).withRel("cuadrantes"));

    }
}

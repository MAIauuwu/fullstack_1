package com.duoc.backend.Comisaria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ComisariaModelAssembler implements RepresentationModelAssembler <Comisaria, EntityModel<Comisaria>> {
    @Override
    public EntityModel<Comisaria> toModel(Comisaria comisaria) {
        return EntityModel.of(comisaria,
                linkTo(methodOn(ComisariaController.class).getComisariaById(comisaria.getIdComisaria())).withSelfRel(),
                linkTo(methodOn(ComisariaController.class).getAllComisaria()).withRel("comisarias")
        );

    }
}

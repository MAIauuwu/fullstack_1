package com.duoc.backend.Comisaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/comisaria")
public class ComisariaController {

  //  @Autowired
  private ComisariaRepository comisariaRepository;

  private final ComisariaModelAssembler assembler;

    public ComisariaController(ComisariaModelAssembler assembler, ComisariaRepository comisariaRepository) {
        this.assembler = assembler;
        this.comisariaRepository = comisariaRepository;
    }

    // Obtener todas
    @GetMapping
    public CollectionModel<EntityModel<Comisaria>> getAllComisaria() {

        List<EntityModel<Comisaria>> comisariasModel = new ArrayList<>();
        comisariaRepository.findAll()
                .forEach(comisaria -> {
                    EntityModel<Comisaria> comisariaEntityModel = assembler.toModel(comisaria);
                    comisariasModel.add(comisariaEntityModel);
                });

         return CollectionModel.of(comisariasModel,
                 linkTo(methodOn(ComisariaController.class).getAllComisaria()).withSelfRel());
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Comisaria>> getComisariaById(@PathVariable Long id) {
        Optional<Comisaria> comisariaOptional = comisariaRepository.findById(id);

        if (comisariaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            EntityModel<Comisaria> comisariaEntityModel = assembler.toModel(comisariaOptional.get());
            return ResponseEntity.ok(comisariaEntityModel);
        }
    }

    @PostMapping
    public Comisaria saveComisaria(@RequestBody Comisaria comisaria) {
        return comisariaRepository.save(comisaria);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComisaria(@PathVariable Long id) {
        comisariaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.duoc.backend.Mensaje;


import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<?> crearMensaje(
            @RequestBody Mensaje dto,
            HttpServletRequest request
    ) {
        if (dto.getRutUsuario() == null) {
            return ResponseEntity.internalServerError().body("rut es nulo");
        }
        if (validarRut(dto.getRutUsuario()) == false) {
            return ResponseEntity.internalServerError().body("rut es invalido");
        }

        dto.setFechaHora(LocalDateTime.now());
        dto.setIp(getClientIp(request));

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


    private String getClientIp(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader != null && !xfHeader.isEmpty()) {
            return xfHeader.split(",")[0];
        }
        return request.getRemoteAddr();
    }

    public boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
}

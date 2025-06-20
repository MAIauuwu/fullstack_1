package com.duoc.backend.Comisaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comisaria")
public class ComisariaController {

    @Autowired
    private ComisariaRepository comisariaRepository;

    // Obtener todas
    @GetMapping
    public Iterable<Comisaria> getAllComisaria() {
        return comisariaRepository.findAll();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Comisaria> getComisariaById(@PathVariable Long id) {
        return comisariaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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

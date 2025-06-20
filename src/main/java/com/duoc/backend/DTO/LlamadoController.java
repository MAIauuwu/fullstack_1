package com.duoc.backend.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/llamados")
public class LlamadoController {

    @Autowired
    private LlamadoService llamadoService;

    @PostMapping("/llamar")
    public ResponseEntity<String> llamarComisaria(@RequestBody LlamadoDTO dto) {
        String mensaje = "Llamado de emergencia desde " + dto.getRutUsuario() +
                " en lat: " + dto.getLatitud() + ", lng: " + dto.getLongitud();
        System.out.println(mensaje);
        return ResponseEntity.ok("Ubicación enviada a la comisaría");
    }
}

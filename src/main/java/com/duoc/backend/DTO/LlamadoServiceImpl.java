package com.duoc.backend.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlamadoServiceImpl implements LlamadoService {

    @Autowired
    private LlamadoRepository llamadoRepository;

    @Override
    public void registrarLlamado(LlamadoDTO dto) {
        Llamado llamado = new Llamado();
        llamado.setRutUsuario(dto.getRutUsuario());
        llamado.setLatitud(dto.getLatitud());
        llamado.setLongitud(dto.getLongitud());

        llamadoRepository.save(llamado);
    }
}

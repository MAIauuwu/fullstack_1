package com.duoc.backend.Mensaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajeServiceImpl implements MensajeService {

    @Autowired
    private MensajeRepository llamadoRepository;

    @Override
    public void registrarLlamado(MensajeDTO dto) {
        Mensaje llamado = new Mensaje();
        llamado.setRutUsuario(dto.getRutUsuario());
        llamado.setLatitud(dto.getLatitud());
        llamado.setLongitud(dto.getLongitud());

        llamadoRepository.save(llamado);
    }
}

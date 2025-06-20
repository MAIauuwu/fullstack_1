package com.duoc.backend.Comisaria;

import org.springframework.beans.factory.annotation.Autowired;


public class ComisariaService {
    @Autowired
    private ComisariaRepository comisariaRepository;

    public Iterable<Comisaria> getAllComisaria() {
        return comisariaRepository.findAll();
    }

    public Comisaria getComisariaById(Long id_Comisaria) {
        return comisariaRepository.findById(id_Comisaria).orElse(null);
    }

    public Comisaria saveComisaria(Comisaria comisaria) {
        return comisariaRepository.save(comisaria);
    }
    
    public void deleteComisaria(Long id_Comisaria) {
        comisariaRepository.deleteById(id_Comisaria);
    }
}

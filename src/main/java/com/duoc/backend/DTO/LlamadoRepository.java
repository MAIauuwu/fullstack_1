package com.duoc.backend.DTO;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LlamadoRepository extends CrudRepository<Llamado, Long> {
}
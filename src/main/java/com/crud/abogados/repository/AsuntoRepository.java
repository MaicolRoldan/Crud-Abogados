package com.crud.abogados.repository;

import com.crud.abogados.entity.Asunto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsuntoRepository extends JpaRepository<Asunto, Long> {
}

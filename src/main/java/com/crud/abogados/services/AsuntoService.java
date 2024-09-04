package com.crud.abogados.services;

import com.crud.abogados.entity.Asunto;
import com.crud.abogados.repository.AsuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsuntoService {
    @Autowired
    private AsuntoRepository asuntoRepository;

    public List<Asunto> findAll() {
        return asuntoRepository.findAll();
    }

    public Asunto save(Asunto asunto) {
        return asuntoRepository.save(asunto);
    }

    public Asunto findById(Long id) {
        return asuntoRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        asuntoRepository.deleteById(id);
    }
}

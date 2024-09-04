package com.crud.abogados.services;

import com.crud.abogados.entity.Procurador;
import com.crud.abogados.repository.ProcuradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcuradorService {
    @Autowired
    private ProcuradorRepository procuradorRepository;

    public List<Procurador> findAll() {
        return procuradorRepository.findAll();
    }

    public Procurador save(Procurador procurador) {
        return procuradorRepository.save(procurador);
    }

    public Procurador findById(Long id) {
        return procuradorRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        procuradorRepository.deleteById(id);
    }
}

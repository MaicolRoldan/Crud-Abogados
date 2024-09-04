package com.crud.abogados.services;

import com.crud.abogados.entity.AsuntoProcurador;
import com.crud.abogados.repository.AsuntoProcuradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsuntoProcuradorService {
    @Autowired
    private AsuntoProcuradorRepository asuntoProcuradorRepository;

    public List<AsuntoProcurador> findAll() {
        return asuntoProcuradorRepository.findAll();
    }

    public AsuntoProcurador save(AsuntoProcurador asuntoProcurador) {
        return asuntoProcuradorRepository.save(asuntoProcurador);
    }

    public AsuntoProcurador findById(Long id) {
        return asuntoProcuradorRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        asuntoProcuradorRepository.deleteById(id);
    }
}

package com.crud.abogados.services;

import com.crud.abogados.entity.Cliente;
import com.crud.abogados.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}


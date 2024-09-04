package com.crud.abogados.controller;

import com.crud.abogados.entity.Cliente;
import com.crud.abogados.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listClientes(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes/index"; // No se debe usar .html aquí
    }

    @GetMapping("/new")
    public String newCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/form"; // No se debe usar .html aquí
    }

    @PostMapping
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/{id}/edit")
    public String editCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "clientes/form"; // No se debe usar .html aquí
    }

    @PostMapping("/{id}")
    public String updateCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id);
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/{id}/delete")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return "redirect:/clientes";
    }
}

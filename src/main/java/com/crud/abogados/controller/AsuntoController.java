package com.crud.abogados.controller;

import com.crud.abogados.entity.Asunto;
import com.crud.abogados.services.AsuntoService;
import com.crud.abogados.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/asuntos")
public class AsuntoController {
    @Autowired
    private AsuntoService asuntoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listAsuntos(Model model) {
        List<Asunto> asuntos = asuntoService.findAll();
        model.addAttribute("asuntos", asuntos);
        return "asuntos/index";
    }

    @GetMapping("/new")
    public String newAsunto(Model model) {
        model.addAttribute("asunto", new Asunto());
        model.addAttribute("clientes", clienteService.findAll());
        return "asuntos/form";
    }

    @PostMapping
    public String saveAsunto(@ModelAttribute Asunto asunto) {
        asuntoService.save(asunto);
        return "redirect:/asuntos";
    }

    @GetMapping("/{id}/edit")
    public String editAsunto(@PathVariable Long id, Model model) {
        Asunto asunto = asuntoService.findById(id);
        model.addAttribute("asunto", asunto);
        model.addAttribute("clientes", clienteService.findAll());
        return "asuntos/form";
    }

    @PostMapping("/{id}")
    public String updateAsunto(@PathVariable Long id, @ModelAttribute Asunto asunto) {
        asunto.setId(id);
        asuntoService.save(asunto);
        return "redirect:/asuntos";
    }

    @GetMapping("/{id}/delete")
    public String deleteAsunto(@PathVariable Long id) {
        asuntoService.delete(id);
        return "redirect:/asuntos";
    }
}

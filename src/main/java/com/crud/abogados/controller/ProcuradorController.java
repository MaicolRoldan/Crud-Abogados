package com.crud.abogados.controller;

import com.crud.abogados.entity.Procurador;
import com.crud.abogados.services.ProcuradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/procuradores")
public class ProcuradorController {
    @Autowired
    private ProcuradorService procuradorService;

    @GetMapping
    public String listProcuradores(Model model) {
        List<Procurador> procuradores = procuradorService.findAll();
        model.addAttribute("procuradores", procuradores);
        return "procuradores/index";
    }

    @GetMapping("/new")
    public String newProcurador(Model model) {
        model.addAttribute("procurador", new Procurador());
        return "procuradores/form";
    }

    @PostMapping
    public String saveProcurador(@ModelAttribute Procurador procurador) {
        procuradorService.save(procurador);
        return "redirect:/procuradores";
    }

    @GetMapping("/{id}/edit")
    public String editProcurador(@PathVariable Long id, Model model) {
        Procurador procurador = procuradorService.findById(id);
        model.addAttribute("procurador", procurador);
        return "procuradores/form";
    }

    @PostMapping("/{id}")
    public String updateProcurador(@PathVariable Long id, @ModelAttribute Procurador procurador) {
        procurador.setId(id);
        procuradorService.save(procurador);
        return "redirect:/procuradores";
    }

    @GetMapping("/{id}/delete")
    public String deleteProcurador(@PathVariable Long id) {
        procuradorService.delete(id);
        return "redirect:/procuradores";
    }
}

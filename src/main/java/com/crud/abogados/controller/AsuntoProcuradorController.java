package com.crud.abogados.controller;

import com.crud.abogados.entity.AsuntoProcurador;
import com.crud.abogados.services.AsuntoProcuradorService;
import com.crud.abogados.services.AsuntoService;
import com.crud.abogados.services.ProcuradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/asuntos-procuradores")
public class AsuntoProcuradorController {
    @Autowired
    private AsuntoProcuradorService asuntoProcuradorService;

    @Autowired
    private AsuntoService asuntoService;

    @Autowired
    private ProcuradorService procuradorService;

    @GetMapping
    public String listAsuntosProcuradores(Model model) {
        List<AsuntoProcurador> asuntoProcuradores = asuntoProcuradorService.findAll();
        model.addAttribute("asuntoProcuradores", asuntoProcuradores);
        return "asuntos-procuradores/index";
    }

    @GetMapping("/new")
    public String newAsuntoProcurador(Model model) {
        model.addAttribute("asuntoProcurador", new AsuntoProcurador());
        model.addAttribute("asuntos", asuntoService.findAll());
        model.addAttribute("procuradores", procuradorService.findAll());
        return "asuntos-procuradores/form";
    }

    @PostMapping
    public String saveAsuntoProcurador(@ModelAttribute AsuntoProcurador asuntoProcurador) {
        asuntoProcuradorService.save(asuntoProcurador);
        return "redirect:/asuntos-procuradores";
    }

    @GetMapping("/{id}/edit")
    public String editAsuntoProcurador(@PathVariable Long id, Model model) {
        AsuntoProcurador asuntoProcurador = asuntoProcuradorService.findById(id);
        model.addAttribute("asuntoProcurador", asuntoProcurador);
        model.addAttribute("asuntos", asuntoService.findAll());
        model.addAttribute("procuradores", procuradorService.findAll());
        return "asuntos-procuradores/form";
    }

    @PostMapping("/{id}")
    public String updateAsuntoProcurador(@PathVariable Long id, @ModelAttribute AsuntoProcurador asuntoProcurador) {
        asuntoProcurador.setId(id);
        asuntoProcuradorService.save(asuntoProcurador);
        return "redirect:/asuntos-procuradores";
    }

    @GetMapping("/{id}/delete")
    public String deleteAsuntoProcurador(@PathVariable Long id) {
        asuntoProcuradorService.delete(id);
        return "redirect:/asuntos-procuradores";
    }
}

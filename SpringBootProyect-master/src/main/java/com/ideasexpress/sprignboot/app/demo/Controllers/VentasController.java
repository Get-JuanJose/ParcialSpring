package com.ideasexpress.sprignboot.app.demo.Controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ideasexpress.sprignboot.app.demo.Models.DAO.IVentaDao;
import com.ideasexpress.sprignboot.app.demo.Models.Entity.Ventas;

@Controller
@SessionAttributes("Ventas")
public class VentasController {

    @Autowired
    private IVentaDao VentasDao;

    @GetMapping("Ventas/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Ventas");
        model.addAttribute("Ventas", VentasDao.findAll());

        return "listar";
    }

    @GetMapping("/form")
    public String crear(Model model) {
        Ventas Ventas = new Ventas();

        model.addAttribute("titulo", "Formulario de ventas");
        model.addAttribute("valor", "Crear ventas");
        model.addAttribute("ventas", Ventas);
        return "form";
    }

    @PostMapping(value = "/form")
    ModelAndView guardar(@Valid Ventas Ventas, BindingResult bindingResult, RedirectAttributes redirectA, SessionStatus status) {
        if (bindingResult.hasErrors()){
                return new ModelAndView("form").addObject("ventas", Ventas);
            }
            VentasDao.save((Ventas));
            redirectA.addFlashAttribute("msgExito", "El contacto se creó");
            return new ModelAndView("redirect:/listar");
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {

        Ventas Ventas = null;

        if (id > 0) {
            Ventas = VentasDao.findOne(id);
        }
        else{
            return "redirect:/listar";
        }

        model.addAttribute("titulo", "Formulario de clientes");
        model.addAttribute("valor", "Editar cliente");
        model.addAttribute("cliente", Ventas);
        return "form";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value= "id") Long id, Model model)
    {
        if(id>0)VentasDao.delete(id);
        return "redirect:/listar";
    }

}
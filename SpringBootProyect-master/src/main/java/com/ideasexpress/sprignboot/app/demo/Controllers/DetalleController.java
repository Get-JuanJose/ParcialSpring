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

import com.ideasexpress.sprignboot.app.demo.Models.DAO.IDetalleDao;
import com.ideasexpress.sprignboot.app.demo.Models.Entity.Detalle;

@Controller
@SessionAttributes("Detalle")
public class DetalleController {

    @Autowired
    private IDetalleDao DetalleDao;

    @GetMapping("Detalle/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de detalle");
        model.addAttribute("Detalle", DetalleDao.findAll());

        return "listar";
    }

    @GetMapping("/form")
    public String crear(Model model) {
        Detalle Detalle = new Detalle();

        model.addAttribute("titulo", "Formulario de detalle");
        model.addAttribute("valor", "Crear detalle");
        model.addAttribute("Detalle", Detalle);
        return "form";
    }

    @PostMapping(value = "/form")
    ModelAndView guardar(@Valid Detalle Detalle, BindingResult bindingResult, RedirectAttributes redirectA, SessionStatus status) {
        if (bindingResult.hasErrors()){
                return new ModelAndView("form").addObject("Detalle", Detalle);
            }
            DetalleDao.save((Detalle));
            redirectA.addFlashAttribute("msgExito", "El contacto se creó");
            return new ModelAndView("redirect:/listar");
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {

        Detalle Detalle = null;

        if (id > 0) {
            Detalle = DetalleDao.findOne(id);
        }
        else{
            return "redirect:/listar";
        }

        model.addAttribute("titulo", "Formulario de detalles");
        model.addAttribute("valor", "Editar Detalle");
        model.addAttribute("Detalle", Detalle);
        return "form";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value= "id") Long id, Model model)
    {
        if(id>0)DetalleDao.delete(id);
        return "redirect:/listar";
    }

}
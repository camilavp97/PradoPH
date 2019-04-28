package com.ppi.prado.ph.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppi.prado.ph.entidades.Propiedad;
import com.ppi.prado.ph.servicios.IPropiedadServices;

@Controller
@RequestMapping("/propiedades")
public class PropiedadControlador {
	
	@Autowired
	private IPropiedadServices propiedadServices;
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("propiedades", propiedadServices.listar());
		modelo.addAttribute("propiedadEntidad", new Propiedad());
		return "propiedad";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable(value ="id") Long id) {
		propiedadServices.eliminar(id);
		return "redirect:/propiedades/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar (@PathVariable(value ="id") Long id, Model modelo) {
		Propiedad propiedadExistente = propiedadServices.consultar(id);
		List<Propiedad> propiedades = propiedadServices.listar();
		modelo.addAttribute("propiedades", propiedades);
		modelo.addAttribute("propiedadEntidad",propiedadExistente);
		return "propieda";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("propiedadEntidad") Propiedad propiedad,BindingResult bindingResult,Model modelo) {
       if (bindingResult.hasErrors()) {
    	    modelo.addAttribute("propiedadEntidad",propiedad);
    		List<Propiedad> propiedades = propiedadServices.listar();
    		modelo.addAttribute("propiedades", propiedades);
            return "propiedad";
        }	
		propiedadServices.guardar(propiedad);
		return "redirect:/propiedades/listar";
	}
	
}

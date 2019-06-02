package com.ppi.prado.ph.controladores;

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

import com.ppi.prado.ph.entidades.LugarReserva;
import com.ppi.prado.ph.servicios.ILugarReservaServices;
import com.ppi.prado.ph.servicios.IPropiedadServices;

@Controller
@RequestMapping("/lugares-reserva")
public class LugarReservaControlador {

	@Autowired
	private ILugarReservaServices lugarReservaServices;
	
	@Autowired
	private IPropiedadServices propiedadesServices;
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("lugaresReserva", lugarReservaServices.listar());
		modelo.addAttribute("propiedades", propiedadesServices.listar());
		modelo.addAttribute("lugarReservaEntidad", new LugarReserva());
		return "lugarreserva";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable(value ="id") Long id) {
		lugarReservaServices.eliminar(id);
		return "redirect:/lugares-reserva/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar (@PathVariable(value ="id") Long id, Model modelo) {
		LugarReserva lugarReservaExistente = lugarReservaServices.consultar(id);
		modelo.addAttribute("lugarReservaEntidad",lugarReservaExistente);
		modelo.addAttribute("lugaresReserva", lugarReservaServices.listar());
		modelo.addAttribute("propiedades", propiedadesServices.listar());
		return "lugarreserva";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("lugarReservaEntidad") LugarReserva lugarReserva, BindingResult bindingResult,Model modelo) {
		//Agregar manualmente la validación de si el perfil de usuario no fue seleccionado
 	   if(lugarReserva.getPropiedad() == null || lugarReserva.getPropiedad().getId() == null ) {
 		bindingResult.rejectValue("propiedad","NotEmpty.lugarReservaEntidad.propiedad");
 	   }
 	   
       if (bindingResult.hasErrors()) {
    	    modelo.addAttribute("lugarReservaEntidad",lugarReserva);
    	    modelo.addAttribute("propiedades", propiedadesServices.listar());
            return "lugarreserva";
        }		
		lugarReservaServices.guardar(lugarReserva);
		return "redirect:/lugares-reserva/listar";
	}
}

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

import com.ppi.prado.ph.entidades.TipoResidente;
import com.ppi.prado.ph.servicios.ITipoResidenteServices;

@Controller
@RequestMapping
public class TipoResidenteControlador {

	@Autowired
	private ITipoResidenteServices tipoResidenteServicesImpl;
	
	@GetMapping("/tiporesidente")
	public String listar(Model modelo) {
		List<TipoResidente> listado = tipoResidenteServicesImpl.listar();
		modelo.addAttribute("tiposResidente", listado);
		modelo.addAttribute("tipoResidenteEntidad", new TipoResidente());
		return "tipoResidente";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable(value ="id") Long id) {
		tipoResidenteServicesImpl.eliminar(id);
		return "redirect:/tiporesidente";
	}
	
	@GetMapping("/editar/{id}")
	public String editar (@PathVariable(value ="id") Long id, Model modelo) {
		TipoResidente tipoResidenteExistente = tipoResidenteServicesImpl.consultar(id);
		List<TipoResidente> listado = tipoResidenteServicesImpl.listar();
		modelo.addAttribute("tiposResidente", listado);
		modelo.addAttribute("tipoResidenteEntidad",tipoResidenteExistente);
		return "tipoResidente";
	}
	
	
	@PostMapping("/tiporesidente")
	public String guardar(@Valid @ModelAttribute("tipoResidenteEntidad") TipoResidente tipoResidente, BindingResult bindingResult, Model modelo) {
		if (bindingResult.hasErrors()) {
			List<TipoResidente> listado = tipoResidenteServicesImpl.listar();
    	    modelo.addAttribute("tipoResidenteEntidad",tipoResidente);
    		modelo.addAttribute("tiposResidente", listado);
            return "tipoResidente";
        }	
		
		tipoResidenteServicesImpl.guardar(tipoResidente);
		return "redirect:/tiporesidente";
	}
	
	
}

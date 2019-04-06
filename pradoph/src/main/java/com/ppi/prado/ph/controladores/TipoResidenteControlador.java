package com.ppi.prado.ph.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		modelo.addAttribute("tipoResidente", new TipoResidente());
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
		modelo.addAttribute("tipoResidente",tipoResidenteExistente);
		return "tipoResidente";
	}
	
	
	@PostMapping("/tiporesidente")
	public String guardar(TipoResidente tipoResidente) {
		tipoResidenteServicesImpl.guardar(tipoResidente);
		return "tipoResidente";
	}
	
	
}

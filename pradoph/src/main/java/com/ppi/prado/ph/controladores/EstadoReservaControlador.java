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

import com.ppi.prado.ph.entidades.EstadoReserva;
import com.ppi.prado.ph.servicios.IEstadoReservaServices;

@Controller
@RequestMapping("/estados-reserva")
public class EstadoReservaControlador {
	
	@Autowired
	private IEstadoReservaServices estadoReservaServices;

	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("estadoReservaEntidad", new EstadoReserva());
		modelo.addAttribute("estadosReserva", estadoReservaServices.listar());
		return "estadoreservaformulario";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		estadoReservaServices.eliminar(id);
		return "redirect:/estados-reserva/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model modelo) {
		EstadoReserva estadoReservaExistente = estadoReservaServices.consultar(id);
		modelo.addAttribute("estadosReserva", estadoReservaServices.listar());
		modelo.addAttribute("estadoReservaEntidad", estadoReservaExistente);
		return "estadoreservaformulario";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("estadoReservaEntidad") EstadoReserva estadoReserva, BindingResult bindingResult,
			Model modelo) {
		if (bindingResult.hasErrors()) {
			modelo.addAttribute("estadosReserva", estadoReservaServices.listar());
			modelo.addAttribute("estadoReservaEntidad", estadoReserva);
			return "estadoreservaformulario";
		}
		estadoReservaServices.guardar(estadoReserva);
		return "redirect:/estados-reserva/listar";
	}
}

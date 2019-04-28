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

import com.ppi.prado.ph.entidades.EstadoSolicitud;
import com.ppi.prado.ph.servicios.IEstadoSolicitudServices;

@Controller
@RequestMapping("/estados-solicitud")
public class EstadoSolicitudControlador {
	
	@Autowired 	
	IEstadoSolicitudServices estadoSolicitudServices;

	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("estadosSolicitud", estadoSolicitudServices.listar());
		modelo.addAttribute("estadoSolicitudEntidad", new EstadoSolicitud());
		return "estadosolicitud";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable(value ="id") Long id) {
		estadoSolicitudServices.eliminar(id);
		return "redirect:/estados-solicitud/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar (@PathVariable(value ="id") Long id, Model modelo) {
		EstadoSolicitud estadoSolicitudExistente = estadoSolicitudServices.consultar(id);
		List<EstadoSolicitud> estadosSolicitud = estadoSolicitudServices.listar();
		modelo.addAttribute("estadosSolicitud", estadosSolicitud);
		modelo.addAttribute("estadoSolicitudEntidad",estadoSolicitudExistente);
		return "estadosolicitud";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("estadoSolicitudEntidad") EstadoSolicitud estadoSolicitud,BindingResult bindingResult,Model modelo) {
       if (bindingResult.hasErrors()) {
   			modelo.addAttribute("estadosSolicitud", estadoSolicitudServices.listar());
    	    modelo.addAttribute("estadoSolicitudEntidad",estadoSolicitud);
            return "estadosolicitud";
        }	
		estadoSolicitudServices.guardar(estadoSolicitud);
		return "redirect:/estados-solicitud/listar";
	}
}

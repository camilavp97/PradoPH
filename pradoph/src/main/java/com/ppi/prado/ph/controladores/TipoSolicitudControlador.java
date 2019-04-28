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

import com.ppi.prado.ph.entidades.TipoSolicitud;
import com.ppi.prado.ph.servicios.ITipoSolicitudServices;

@Controller
@RequestMapping ("/tipos-solicitud")
public class TipoSolicitudControlador {
	
	@Autowired
	private ITipoSolicitudServices tiposSolicitudServices;
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("tiposSolicitud", tiposSolicitudServices.listar());
		modelo.addAttribute("tipoSolicitudEntidad", new TipoSolicitud());
		return "tiposolicitud";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable(value ="id") Long id) {
		tiposSolicitudServices.eliminar(id);
		return "redirect:/tipos-solicitud/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar (@PathVariable(value ="id") Long id, Model modelo) {
		TipoSolicitud tipoSolicitudExistente = tiposSolicitudServices.consultar(id);
		List<TipoSolicitud> tiposSolicitud = tiposSolicitudServices.listar();
		modelo.addAttribute("tiposSolicitud", tiposSolicitud);
		modelo.addAttribute("tipoSolicitudEntidad",tipoSolicitudExistente);
		return "tiposolicitud";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("tipoSolicitudEntidad") TipoSolicitud tipoSolicitud,BindingResult bindingResult,Model modelo) {
       if (bindingResult.hasErrors()) {
    	    modelo.addAttribute("tipoSolicitudEntidad",tipoSolicitud);
    		List<TipoSolicitud> tiposSolicitud = tiposSolicitudServices.listar();
    		modelo.addAttribute("tiposSolicitud", tiposSolicitud);
            return "tiposolicitud";
        }	
		tiposSolicitudServices.guardar(tipoSolicitud);
		return "redirect:/tipos-solicitud/listar";
	}
}

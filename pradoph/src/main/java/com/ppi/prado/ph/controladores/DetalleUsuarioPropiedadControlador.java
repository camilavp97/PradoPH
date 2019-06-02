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

import com.ppi.prado.ph.entidades.DetalleUsuarioPropiedad;
import com.ppi.prado.ph.servicios.IDetalleUsuarioPropiedadServices;
import com.ppi.prado.ph.servicios.IPropiedadServices;
import com.ppi.prado.ph.servicios.IUsuarioServices;

@Controller
@RequestMapping("/detalles-usuario-propiedad")
public class DetalleUsuarioPropiedadControlador {

	@Autowired
	private IDetalleUsuarioPropiedadServices detalleUsuarioPropiedadServices;
	
	@Autowired
	private IUsuarioServices usuarioServices;
	
	@Autowired
	private IPropiedadServices propiedadServices;
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("detalles", detalleUsuarioPropiedadServices.listar());
		modelo.addAttribute("usuarios", usuarioServices.listar());
		modelo.addAttribute("propiedades", propiedadServices.listar());		
		modelo.addAttribute("detalleEntidad", new DetalleUsuarioPropiedad());
		return "detalleusuariopropiedad";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable(value ="id") Long id) {
		detalleUsuarioPropiedadServices.eliminar(id);
		return "redirect:/detalles-usuario-propiedad/listar";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("detalleEntidad") DetalleUsuarioPropiedad detalleUsuarioPropiedad,BindingResult bindingResult,Model modelo) {
		
	   if(detalleUsuarioPropiedad.getUsuario() == null || detalleUsuarioPropiedad.getUsuario().getId() == null ) {
	 	 		bindingResult.rejectValue("usuario","NotEmpty.detalleEntidadUsuarioPropiedad.usuario");
 	   }
	   
	   if(detalleUsuarioPropiedad.getPropiedad() == null || detalleUsuarioPropiedad.getPropiedad().getId() == null ) {
	 		bindingResult.rejectValue("propiedad","NotEmpty.detalleEntidadUsuarioPropiedad.propiedad");
	   }
	   
	   if(!bindingResult.hasErrors() && detalleUsuarioPropiedadServices.existeDetallePorUsuarioYPropiedad(detalleUsuarioPropiedad.getUsuario().getId(), detalleUsuarioPropiedad.getPropiedad().getId())) {
		   bindingResult.rejectValue("propiedad","","Ya existe un registro con los mismos valores.");
	   }
		
       if (bindingResult.hasErrors()) {
    	    modelo.addAttribute("detalleEntidad",detalleUsuarioPropiedad);
    		List<DetalleUsuarioPropiedad> detalles = detalleUsuarioPropiedadServices.listar();
    		modelo.addAttribute("detalles", detalles);
    		modelo.addAttribute("usuarios", usuarioServices.listar());
    		modelo.addAttribute("propiedades", propiedadServices.listar());	
            return "detalleusuariopropiedad";
        }	
		detalleUsuarioPropiedadServices.guardar(detalleUsuarioPropiedad);
		return "redirect:/detalles-usuario-propiedad/listar";
	}	
}

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

import com.ppi.prado.ph.entidades.Apartamento;
import com.ppi.prado.ph.servicios.IApartamentoServices;
import com.ppi.prado.ph.servicios.IPropiedadServices;
import com.ppi.prado.ph.servicios.IUsuarioServices;

@Controller
@RequestMapping("/apartamentos")
public class ApartamentoControlador {

	@Autowired
	private IApartamentoServices apartamentoServices;
	
	@Autowired
	private IPropiedadServices propiedadesServices;
	
	@Autowired
	private IUsuarioServices usuariosServices;
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("apartamentos", apartamentoServices.listar());
		modelo.addAttribute("propiedades", propiedadesServices.listar());
		modelo.addAttribute("usuarios", usuariosServices.listar());
		modelo.addAttribute("apartamentoEntidad", new Apartamento());
		return "apartamento";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable(value ="id") Long id) {
		apartamentoServices.eliminar(id);
		return "redirect:/apartamentos/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar (@PathVariable(value ="id") Long id, Model modelo) {
		Apartamento apartamentoExistente = apartamentoServices.consultar(id);
		modelo.addAttribute("apartamentoEntidad",apartamentoExistente);
		modelo.addAttribute("apartamentos", apartamentoServices.listar());
		modelo.addAttribute("propiedades", propiedadesServices.listar());
		modelo.addAttribute("usuarios", usuariosServices.listar());
		return "apartamento";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("apartamentoEntidad") Apartamento apartamento, BindingResult bindingResult,Model modelo) {
		//Agregar manualmente la validación de si el perfil de usuario no fue seleccionado
 	   if(apartamento.getPropiedad() == null || apartamento.getPropiedad().getId() == null ) {
 		bindingResult.rejectValue("propiedad","NotEmpty.apartamentoEntidad.propiedad");
 	   }
 	   
 	  if(apartamento.getUsuario() == null || apartamento.getUsuario().getId() == null ) {
 	 		bindingResult.rejectValue("usuario","NotEmpty.apartamentoEntidad.usuario");
 	 	   }
 	   
       if (bindingResult.hasErrors()) {
    	    modelo.addAttribute("apartamentoEntidad",apartamento);
    	    modelo.addAttribute("propiedades", propiedadesServices.listar());
    	    modelo.addAttribute("usuarios", usuariosServices.listar());
            return "apartamento";
        }		
       
		apartamentoServices.guardar(apartamento);
		return "redirect:/apartamentos/listar";
	}
}

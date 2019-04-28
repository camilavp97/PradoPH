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

import com.ppi.prado.ph.entidades.PerfilUsuario;
import com.ppi.prado.ph.servicios.IPerfilUsuarioServices;

@Controller
@RequestMapping("/perfiles-usuario")
public class PerfilUsuarioControlador {
	
	@Autowired
	private IPerfilUsuarioServices perfilUsuarioServices;
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("perfilesUsuario", perfilUsuarioServices.listar());
		modelo.addAttribute("perfilUsuarioEntidad", new PerfilUsuario());
		return "perfilusuario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable(value ="id") Long id) {
		perfilUsuarioServices.eliminar(id);
		return "redirect:/perfiles-usuario/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar (@PathVariable(value ="id") Long id, Model modelo) {
		PerfilUsuario perfilUsuarioExistente = perfilUsuarioServices.consultar(id);
		List<PerfilUsuario> perfilesUsuario = perfilUsuarioServices.listar();
		modelo.addAttribute("perfilesUsuario", perfilesUsuario);
		modelo.addAttribute("perfilUsuarioEntidad",perfilUsuarioExistente);
		return "perfilUsuario";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("perfilUsuarioEntidad") PerfilUsuario perfilUsuario,BindingResult bindingResult,Model modelo) {
       if (bindingResult.hasErrors()) {
    	    modelo.addAttribute("perfilUsuarioEntidad",perfilUsuario);
    		List<PerfilUsuario> perfilesUsuario = perfilUsuarioServices.listar();
    		modelo.addAttribute("perfilesUsuario", perfilesUsuario);
            return "perfilUsuario";
        }	
		perfilUsuarioServices.guardar(perfilUsuario);
		return "redirect:/perfiles-usuario/listar";
	}
	
}

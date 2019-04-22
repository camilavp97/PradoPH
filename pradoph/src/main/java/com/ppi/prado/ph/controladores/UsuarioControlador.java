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

import com.ppi.prado.ph.entidades.Usuario;
import com.ppi.prado.ph.servicios.IPerfilUsuarioServices;
import com.ppi.prado.ph.servicios.IUsuarioServices;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {

	@Autowired
	private IUsuarioServices usuarioServices;
	
	@Autowired
	private IPerfilUsuarioServices perfilesUsuarioServices;
	
	@GetMapping("/crear")
	public String crear(Model modelo) {
		modelo.addAttribute("usuarioEntidad", new Usuario());
		modelo.addAttribute("perfiles", perfilesUsuarioServices.listar());
		return "usuarioformulario";
	}
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("usuarios", usuarioServices.listar());
		return "usuario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable(value ="id") Long id) {
		usuarioServices.eliminar(id);
		return "redirect:/usuarios/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar (@PathVariable(value ="id") Long id, Model modelo) {
		Usuario usuarioExistente = usuarioServices.consultar(id);
		modelo.addAttribute("usuarioEntidad",usuarioExistente);
		modelo.addAttribute("perfiles", perfilesUsuarioServices.listar());
		return "usuarioformulario";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("usuarioEntidad") Usuario usuario, BindingResult bindingResult,Model modelo) {
       if (bindingResult.hasErrors()) {
    	    modelo.addAttribute("usuarioEntidad",usuario);
            return "usuarioformulario";
        }		
		usuarioServices.guardar(usuario);
		return "redirect:/usuarios/listar";
	}
}

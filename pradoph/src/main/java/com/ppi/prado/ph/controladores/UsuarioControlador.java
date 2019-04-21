package com.ppi.prado.ph.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppi.prado.ph.entidades.PerfilUsuario;
import com.ppi.prado.ph.entidades.Usuario;
import com.ppi.prado.ph.servicios.IUsuarioServices;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {

	@Autowired
	private IUsuarioServices usuarioServices;
	
	@GetMapping("/crear")
	public String crear(Model modelo) {
		modelo.addAttribute("usuarioEntidad", new PerfilUsuario());
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
		List<Usuario> usuarios = usuarioServices.listar();
		modelo.addAttribute("usuarios", usuarios);
		modelo.addAttribute("usuarioEntidad",usuarioExistente);
		return "usuario";
	}
	
	@PostMapping("/guardar")
	public String guardar(Usuario usuario) {
		usuarioServices.guardar(usuario);
		return "redirect:/usuarios/listar";
	}
}

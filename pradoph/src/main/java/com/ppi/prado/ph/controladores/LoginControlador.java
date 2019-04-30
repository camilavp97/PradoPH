package com.ppi.prado.ph.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ppi.prado.ph.entidades.Usuario;
import com.ppi.prado.ph.servicios.IUsuarioServices;

@Controller
@RequestMapping("/login")
public class LoginControlador {
	
	@Autowired
	private IUsuarioServices usuarioServices;
	
	@GetMapping("formulario")
	public String login() {
		return "login";
	}
	
	@PostMapping("/ingresar")
	public String ingresar(@RequestParam(value="usuario") String usuario,
			@RequestParam(value="clave") String clave, Model modelo) {
		String mensajeError = "";
		
		if(usuario == null || usuario.equals("")) {
			mensajeError = "El campo Nombre usuario es requerido.";
		}
		
		if(clave == null || clave.equals("")) {
			mensajeError = "El campo Contraseña es requerido.";
		}
		
		if (mensajeError.equals("")) {
			Usuario usuarioExistente = usuarioServices.consultarUsuarioPorNombreUsuarioYClave(usuario, clave);
			if(usuarioExistente != null) {
				//Autenticación ok
				return "";
			}else {
				//Usuario y clave incorrectos 
				return "";
			}
			
		}
		return "login";
	}

}
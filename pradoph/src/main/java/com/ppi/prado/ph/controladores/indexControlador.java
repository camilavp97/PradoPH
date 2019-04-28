package com.ppi.prado.ph.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class indexControlador {

	@GetMapping("/tables")
	public String listar(Model modelo) {
		return "tables";
	}
}

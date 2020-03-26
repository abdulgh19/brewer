package com.abdul.boot.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abdul.boot.brewer.domain.Cerveja;

@Controller
@RequestMapping("/brewer/cervejas")
public class CervejaController {
	
	@GetMapping({"novo"})
	public String abrir(Cerveja cerveja) {

		return "cerveja/Cadastro";
	}
	
	@PostMapping({"nova"})
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result) {
		
		if (result.hasErrors()) {
			
		}

		return "cerveja/Cadastro";
	}
	
	@GetMapping({"nova"})
	public String abrirPagina(Cerveja cerveja) {

		return "cerveja/CadastroCerveja";
	}
	
	
	

}

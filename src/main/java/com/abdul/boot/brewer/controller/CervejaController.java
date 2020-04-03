package com.abdul.boot.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abdul.boot.brewer.domain.Cerveja;
import com.abdul.boot.brewer.domain.Origem;
import com.abdul.boot.brewer.domain.Sabor;
import com.abdul.boot.brewer.repository.EstiloRepository;
import com.abdul.boot.brewer.service.CervejaService;

@Controller
@RequestMapping("/brewer/cervejas")
public class CervejaController {
	

	@Autowired
	private CervejaService service;
	
	@Autowired
	private EstiloRepository estiloRepository;
	
	
	@GetMapping({"nova"})
	public ModelAndView abrirPagina(Cerveja cerveja) {
		ModelAndView modelAndView = new ModelAndView("cerveja/CadastroCerveja");
		modelAndView.addObject("sabores", Sabor.values());
		modelAndView.addObject("estilos", estiloRepository.findAll()); 			//Retorna uma Lista
		modelAndView.addObject("origens", Origem.values());						//Retorna um array
		return modelAndView;
	}
		
	
	@PostMapping({"nova"})
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, ModelAndView model, RedirectAttributes attributes) {
		
		 if (result.hasErrors()) {
			return abrirPagina(cerveja);
		 }
		 
		service.salvar(cerveja);
		attributes.addFlashAttribute("mensagem","Cerveja Cadastrada com Sucesso");
		return new ModelAndView("redirect:/brewer/cervejas/nova");
	}


}

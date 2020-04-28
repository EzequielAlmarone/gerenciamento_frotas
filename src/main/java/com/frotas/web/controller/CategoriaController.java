package com.frotas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frotas.web.domain.Categoria;
import com.frotas.web.repository.CategoriaDAO;

@Controller
@RequestMapping("/veiculo")
public class CategoriaController {
	@Autowired
	private CategoriaDAO categorias;
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
	return "/veiculo/cadastro_categoria";	
	}
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("lista_categoria");
		modelAndView.addObject("categorias", categorias.findAll());
		return modelAndView;
	}
	@PostMapping("/salvar")
	public String salvar(Categoria categoria) {
		this.categorias.save(categoria);
		return "redirect:/veiculo/lista_categoria";
	}
	
	

}

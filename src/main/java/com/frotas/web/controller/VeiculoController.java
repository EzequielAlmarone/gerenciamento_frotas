package com.frotas.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.frotas.web.domain.Categoria;
import com.frotas.web.domain.Fipe;
import com.frotas.web.domain.Veiculo;
import com.frotas.web.domain.enums.Combustivel;
import com.frotas.web.services.CategoriaService;
import com.frotas.web.services.FipeService;
import com.frotas.web.services.VeiculoService;

@Controller
@RequestMapping("/veiculo/veiculo")
public class VeiculoController {
	@Autowired
	private  VeiculoService service;
	@Autowired
	private FipeService fipeService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Veiculo veiculo, ModelMap model) {
		List<Fipe> listaFipe = new ArrayList<>();
		listaFipe = fipeService.findAll();
		model.addAttribute("fipes", listaFipe);
		List<Categoria> listaCategoria = new ArrayList<>();
		listaCategoria = categoriaService.findAll();
		model.addAttribute("categorias", listaCategoria);
		List<Combustivel> listaCombustivel = new ArrayList<>();
		listaCombustivel = Combustivel.getEnum();
		model.addAttribute("combustiveis", listaCombustivel);
	return "veiculo/cadastro_veiculo";	 
	}
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("veiculos", service.findAll());
		return "/veiculo/lista_categoria"; 
	}
	@PostMapping("/salvar")
	public String salvar(Veiculo veiculo, RedirectAttributes attr) {
		this.service.save(veiculo);
		attr.addFlashAttribute("success", "Veículo adicionada com sucesso!");
		return "redirect:/veiculo/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("veiculo", service.findById(id));
		return "/veiculo/cadastro_veiculo";
	}
	
	@PostMapping("/editar")
	public String editar(Veiculo veiculo, RedirectAttributes attr) {
		this.service.update(veiculo);
		attr.addFlashAttribute("success", "Veiculo alterada com sucesso!");
		return "redirect:/veiculo/cadastrar";
	}
	
	

}

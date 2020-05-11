package com.frotas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.frotas.web.domain.Categoria;
import com.frotas.web.services.CategoriaService;

@Controller
@RequestMapping("/veiculo")
public class CategoriaController {
	@Autowired
	private CategoriaService service;
	
	private Categoria categoria;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Categoria categoria) {
	return "veiculo/cadastro_categoria";	 
	}
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("categorias", service.findAll());
		return "/veiculo/lista_categoria"; 
	}
	@PostMapping("/salvar")
	public String salvar(Categoria categoria, RedirectAttributes attr) {
		this.service.save(categoria);
		attr.addFlashAttribute("success", "Categoria \"" + categoria.getCategoria() +"\" adicionada com sucesso!");
		return "redirect:/veiculo/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		categoria = service.findById(id);
		model.addAttribute("categoria", categoria);
		return "/veiculo/cadastro_categoria";
	}
	
	@PostMapping("/editar")
	public String editar(Categoria categoria, RedirectAttributes attr) {
		this.service.update(categoria);
		attr.addFlashAttribute("success", "Categoria \""+ this.categoria.getCategoria() + "\" foi alterada para \"" + categoria.getCategoria() + "\" com sucesso " );
		return "redirect:/veiculo/cadastrar";
	} 
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if(service.categoriaTemVeiculo(id)) {
			model.addAttribute("fail", "A categoria não pode ser removida, pois a veículo Cadastrado a está categoria");
		}else {
			service.delete(id);
			model.addAttribute("success", "A categoria foi removida com sucesso");
		}
		return listar(model);
	}
	
	

}

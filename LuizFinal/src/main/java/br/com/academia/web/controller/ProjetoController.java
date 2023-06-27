package br.com.academia.web.controller;

import br.com.academia.domain.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.academia.service.ProjetoService;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {
	
	@Autowired
	private ProjetoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Projeto projeto) {
		return "projeto/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("projetos", service.buscarTodos());
		return "projeto/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Projeto projeto, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "projeto/cadastro";
		}
		
		service.salvar(projeto);
		attr.addFlashAttribute("success", "Projeto inserido com sucesso.");
		return "redirect:/projetos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("projeto", service.buscarPorId(id));
		return "projeto/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Projeto projeto, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "projeto/cadastro";
		}
		
		service.editar(projeto);
		attr.addFlashAttribute("success", "Projeto editado com sucesso.");
		return "redirect:/projetos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if (service.projetoTemUsuarios(id)) {
			model.addAttribute("fail", "Projeto não removido. Possui usuario(s) vinculado(s).");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Projeto excluído com sucesso.");
		}
		
		return listar(model);
	}
	
	
}

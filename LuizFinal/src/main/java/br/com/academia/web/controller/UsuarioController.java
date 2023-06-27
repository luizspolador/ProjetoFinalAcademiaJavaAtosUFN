package br.com.academia.web.controller;

import java.util.List;
import java.util.Optional;

import br.com.academia.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.academia.domain.Projeto;
import br.com.academia.service.UsuarioService;
import br.com.academia.service.ProjetoService;
import br.com.academia.util.PaginacaoUtil;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ProjetoService projetoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		return "usuario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model, 
						 @RequestParam("page") Optional<Integer> page, 
						 @RequestParam("dir") Optional<String> dir) {
		
		int paginaAtual = page.orElse(1);
		String ordem = dir.orElse("asc");		
		
		PaginacaoUtil<Usuario> pageUsuario = usuarioService.buscarPorPagina(paginaAtual, ordem);
		
		model.addAttribute("pageUsuario", pageUsuario);
		return "usuario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Usuario usuario, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "usuario/cadastro";
		}
		
		usuarioService.salvar(usuario);
		attr.addFlashAttribute("success", "Usuario inserido com sucesso.");
		return "redirect:/usuarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("usuario", usuarioService.buscarPorId(id));
		return "usuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Usuario usuario, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "usuario/cadastro";
		}	
		
		usuarioService.editar(usuario);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/usuarios/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (usuarioService.usuarioTemAmostras(id)) {
			attr.addFlashAttribute("fail", "Usuário não excluido. Tem amostra(s) vinculada(s).");
		} else {
			usuarioService.excluir(id);
			attr.addFlashAttribute("success", "Usuário excluido com sucesso.");
		}
		return "redirect:/usuarios/listar";
	}
	
	@ModelAttribute("projetos")
	public List<Projeto> listaDeProjetos() {
		return projetoService.buscarTodos();
	}	
}

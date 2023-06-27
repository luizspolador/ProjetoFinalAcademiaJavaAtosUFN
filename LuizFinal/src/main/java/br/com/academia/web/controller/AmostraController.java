package br.com.academia.web.controller;

import java.time.LocalDate;
import java.util.List;


import br.com.academia.domain.Amostra;
import br.com.academia.web.validator.AmostraValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.academia.domain.Usuario;
import br.com.academia.domain.UF;
import br.com.academia.service.UsuarioService;
import br.com.academia.service.AmostraService;

@Controller
@RequestMapping("/amostras")
public class AmostraController {
	
	@Autowired
	private AmostraService amostraService;
	@Autowired
	private UsuarioService usuarioService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new AmostraValidator());
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Amostra amostra) {
		return "amostra/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("amostras", amostraService.buscarTodas());
		return "amostra/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Amostra amostra, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "amostra/cadastro";
		}
		
		amostraService.salvar(amostra);
		attr.addFlashAttribute("success", "Amostra inserida com sucesso.");
		return "redirect:/amostras/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("amostra", amostraService.buscarPorId(id));
		return "amostra/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Amostra amostra, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "amostra/cadastro";
		}
		
		amostraService.editar(amostra);
		attr.addFlashAttribute("success", "Amostra editada com sucesso.");
		return "redirect:/amostras/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		amostraService.excluir(id);
		attr.addFlashAttribute("success", "Amostra removida com sucesso.");
		return "redirect:/amostras/listar";
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("amostras", amostraService.buscarPorNome(nome));
		return "amostra/lista";
	}
	
	@GetMapping("/buscar/usuario")
	public String getPorUsuario(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("amostras", amostraService.buscarPorUsuario(id));
		return "amostra/lista";
	}		
	
    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam("coleta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate coleta,
                              @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
                              ModelMap model) {

        model.addAttribute("amostras", amostraService.buscarPorDatas(coleta, fim));
        return "amostra/lista";
    }
	
	@ModelAttribute("usuarios")
	public List<Usuario> getUsuarios() {
		return usuarioService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}

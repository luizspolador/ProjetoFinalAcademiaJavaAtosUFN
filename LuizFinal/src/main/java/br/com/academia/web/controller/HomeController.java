package br.com.academia.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/")
	public String home2() {
		return "home";
	}

	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}

	@GetMapping("/contato2")
	public String contato2() {
		return "contato2";
	}
}

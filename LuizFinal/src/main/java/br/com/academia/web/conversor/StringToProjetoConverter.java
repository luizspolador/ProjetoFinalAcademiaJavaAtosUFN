package br.com.academia.web.conversor;

import br.com.academia.domain.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.academia.service.ProjetoService;

@Component
public class StringToProjetoConverter implements Converter<String, Projeto> {
	
	@Autowired
	private ProjetoService service;

	@Override
	public Projeto convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}

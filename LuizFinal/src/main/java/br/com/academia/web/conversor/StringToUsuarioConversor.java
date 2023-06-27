package br.com.academia.web.conversor;

import br.com.academia.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.academia.service.UsuarioService;

@Component
public class StringToUsuarioConversor implements Converter<String, Usuario> {

	@Autowired
	private UsuarioService service;
	
	@Override
	public Usuario convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}

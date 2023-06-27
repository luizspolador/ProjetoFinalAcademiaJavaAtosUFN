package br.com.academia.service;

import java.util.List;

import br.com.academia.domain.Usuario;
import br.com.academia.util.PaginacaoUtil;

public interface UsuarioService {

	void salvar(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario buscarPorId(Long id);
	
	List<Usuario> buscarTodos();
	
	boolean usuarioTemAmostras(Long id);
	
	PaginacaoUtil<Usuario> buscarPorPagina(int pagina, String direcao);
}

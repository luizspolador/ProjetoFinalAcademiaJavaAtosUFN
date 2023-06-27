package br.com.academia.service;

import java.util.List;

import br.com.academia.domain.Projeto;

public interface ProjetoService {

    void salvar(Projeto projeto);

    void editar(Projeto projeto);

    void excluir(Long id);

    Projeto buscarPorId(Long id);
    
    List<Projeto> buscarTodos();

	boolean projetoTemUsuarios(Long id);
}

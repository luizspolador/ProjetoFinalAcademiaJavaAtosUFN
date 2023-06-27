package br.com.academia.dao;

import java.util.List;

import br.com.academia.domain.Projeto;

public interface ProjetoDao {

    void save(Projeto projeto);

    void update(Projeto projeto);

    void delete(Long id);

    Projeto findById(Long id);

    List<Projeto> findAll();
}

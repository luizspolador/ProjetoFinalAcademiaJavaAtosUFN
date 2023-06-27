package br.com.academia.service;

import java.time.LocalDate;
import java.util.List;

import br.com.academia.domain.Amostra;

public interface AmostraService {

    void salvar(Amostra amostra);

    void editar(Amostra amostra);

    void excluir(Long id);

    Amostra buscarPorId(Long id);

    List<Amostra> buscarTodas();

	List<Amostra> buscarPorNome(String nome);

	List<Amostra> buscarPorUsuario(Long id);
	
	List<Amostra> buscarPorDatas(LocalDate coleta, LocalDate fim);
}

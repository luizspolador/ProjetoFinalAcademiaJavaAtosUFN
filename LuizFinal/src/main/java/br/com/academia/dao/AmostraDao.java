package br.com.academia.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.academia.domain.Amostra;

public interface AmostraDao {
    
	void save(Amostra amostra);

    void update(Amostra amostra);

    void delete(Long id);

    Amostra findById(Long id);

    List<Amostra> findAll();
    
    List<Amostra> findByNome(String nome);

	List<Amostra> findByUsuarioId(Long id);

	List<Amostra> findByDataColetaDataFim(LocalDate coleta, LocalDate fim);

	List<Amostra> findByDataColeta(LocalDate coleta);

	List<Amostra> findByDataFim(LocalDate fim);
}

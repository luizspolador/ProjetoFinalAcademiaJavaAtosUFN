package br.com.academia.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.academia.domain.Amostra;
import org.springframework.stereotype.Repository;

@Repository
public class AmostraDaoImpl extends AbstractDao<Amostra, Long> implements AmostraDao {

	public List<Amostra> findByNome(String nome) {
		
		return createQuery("select a from Amostra a where a.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Amostra> findByUsuarioId(Long id) {
		
		return createQuery("select a from Amostra a where a.usuario.id = ?1", id);
	}

	@Override
	public List<Amostra> findByDataColetaDataFim(LocalDate coleta, LocalDate fim) {
		String jpql = new StringBuilder("select a from Amostra a ")
				.append("where a.dataColeta >= ?1 and a.dataFim <= ?2 ")
				.append("order by a.dataColeta asc")
				.toString();
		return createQuery(jpql, coleta, fim);
	}

	@Override
	public List<Amostra> findByDataColeta(LocalDate coleta) {
		String jpql = new StringBuilder("select a from Amostra a ")
				.append("where a.dataColeta = ?1 ")
				.append("order by a.dataColeta asc")
				.toString();
		return createQuery(jpql, coleta);
	}

	@Override
	public List<Amostra> findByDataFim(LocalDate fim) {
		String jpql = new StringBuilder("select a from Amostra a ")
				.append("where a.dataFim = ?1 ")
				.append("order by a.dataColeta asc")
				.toString();
		return createQuery(jpql, fim);
	}	
	
}

package br.com.academia.dao;

import java.util.List;

import br.com.academia.domain.Usuario;
import org.springframework.stereotype.Repository;

import br.com.academia.util.PaginacaoUtil;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {

	public PaginacaoUtil<Usuario> buscaPaginada(int pagina, String direcao) {
		int tamanho = 5;
		int inicio = (pagina - 1) * tamanho; // 0*5=0 1*5=5 2*5=10
		List<Usuario> usuarios = getEntityManager()
				.createQuery("select u from Usuario u order by u.nome " + direcao, Usuario.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		
		long totalRegistros = count();
		long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;
		
		return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, usuarios);
	}
	
	public long count() {
		return getEntityManager()
				.createQuery("select count(*) from Usuario", Long.class)
				.getSingleResult();
	}
}

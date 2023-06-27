package br.com.academia.service;

import java.util.List;

import br.com.academia.dao.UsuarioDao;
import br.com.academia.domain.Usuario;
import br.com.academia.util.PaginacaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDao dao;

	@Override
	public void salvar(Usuario usuario) {
		dao.save(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		dao.update(usuario);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Usuario> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public boolean usuarioTemAmostras(Long id) {
		if (buscarPorId(id).getAmostras().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public PaginacaoUtil<Usuario> buscarPorPagina(int pagina, String direcao) {
		
		return dao.buscaPaginada(pagina, direcao);
	}
}

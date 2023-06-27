package br.com.academia.service;

import java.util.List;

import br.com.academia.dao.ProjetoDao;
import br.com.academia.domain.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjetoServiceImpl implements ProjetoService {
	
	@Autowired
	private ProjetoDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Projeto projeto) {
		dao.save(projeto);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Projeto projeto) {
		dao.update(projeto);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Projeto buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Projeto> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public boolean projetoTemUsuarios(Long id) {
		if (buscarPorId(id).getUsuarios().isEmpty()) {
			return false;
		}
		return true;
	}

}

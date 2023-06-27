package br.com.academia.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.academia.dao.AmostraDao;
import br.com.academia.domain.Amostra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AmostraServiceImpl implements AmostraService {
	
	@Autowired
	private AmostraDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Amostra amostra) {
		dao.save(amostra);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Amostra amostra) {
		dao.update(amostra);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Amostra buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Amostra> buscarTodas() {
		
		return dao.findAll();
	}

	@Override
	public List<Amostra> buscarPorNome(String nome) {
		
		return dao.findByNome(nome);
	}

	@Override
	public List<Amostra> buscarPorUsuario(Long id) {
		
		return dao.findByUsuarioId(id);
	}

	@Override
    public List<Amostra> buscarPorDatas(LocalDate coleta, LocalDate fim) {
	    if (coleta != null && fim != null) {
            return dao.findByDataColetaDataFim(coleta, fim);
        } else if (coleta != null) {
	        return dao.findByDataColeta(coleta);
        } else if (fim != null) {
	        return dao.findByDataFim(fim);
        } else {
        	return new ArrayList<>();
        }
    }
}

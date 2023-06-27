package br.com.academia.dao;

import java.util.List;

import br.com.academia.domain.Usuario;
import br.com.academia.util.PaginacaoUtil;

public interface UsuarioDao {

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Long id);

    Usuario findById(Long id);

    List<Usuario> findAll();
    
    PaginacaoUtil<Usuario> buscaPaginada(int pagina, String direcao);
}

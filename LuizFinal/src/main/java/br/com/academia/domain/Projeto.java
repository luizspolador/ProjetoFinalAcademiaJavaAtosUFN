package br.com.academia.domain;

import java.util.List;

import jakarta.persistence.*;
@SuppressWarnings("serial")
@Entity
@Table(name = "Projetos")
public class Projeto extends AbstractEntity<Long> {


	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "projeto")
	private List<Usuario> usuarios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}

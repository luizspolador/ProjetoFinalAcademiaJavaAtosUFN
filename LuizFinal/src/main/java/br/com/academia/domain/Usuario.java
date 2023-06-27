package br.com.academia.domain;

import java.util.List;

import jakarta.persistence.*;
@SuppressWarnings("serial")
@Entity
@Table(name = "Usuarios")
public class Usuario extends AbstractEntity<Long> {

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	

	@ManyToOne
	@JoinColumn(name = "id_projeto_fk")
	private Projeto projeto;
	
	@OneToMany(mappedBy = "usuario")
	private List<Amostra> amostras;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Amostra> getAmostras() {
		return amostras;
	}

	public void setAmostras(List<Amostra> amostras) {
		this.amostras = amostras;
	} 	
}

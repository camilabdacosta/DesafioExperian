package com.desafio.desafioExperian.dominio;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consultas")
public class Consulta implements Serializable {

	private static final long serialVersionUID = 1L;

// atributos:
	@Id
	private String id;

	private String nome;
	private String cidade;
	private String telefone;
	private String estado;
	private int idade;
	private int score;


	// construtor 1:
	public Consulta() {
	}

	// construtor 2:
	public Consulta(String id, String nome, String cidade, String telefone, String estado, int idade, int score) {

		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.telefone = telefone;
		this.estado = estado;
		this.idade = idade;
		this.score = score;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return id == other.id;
	}

}

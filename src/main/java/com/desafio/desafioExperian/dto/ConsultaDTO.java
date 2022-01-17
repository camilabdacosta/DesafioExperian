package com.desafio.desafioExperian.dto;

import java.io.Serializable;

import com.desafio.desafioExperian.dominio.Consulta;

public class ConsultaDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	private String id;
	private String nome;
	private String cidade;
	private String telefone;
	private String estado;
	private int idade;
	private int score;


	//construtor dto1:
	public ConsultaDTO() {

	}

	// contrutor dto2: para ter uma forma automatizada de instanciar um objt do tipo dto a partir do Consulta_Score
	public ConsultaDTO(Consulta obj) {
		id = obj.getId();
		nome = obj.getNome();
		cidade = obj.getCidade();
		estado = obj.getEstado();
		telefone = obj.getTelefone();
		idade = obj.getIdade();
		score = obj.getScore();
	}

	// metodos getters e setters dto:

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
}




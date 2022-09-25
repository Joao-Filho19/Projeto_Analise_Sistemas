package model.entities;

import java.io.Serializable;
import java.util.Objects;

import model.entities.enums.Modalidade;

public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cpf;
	private Modalidade modalidade;
	private String telefone;
	
	public Aluno() {
		
	}

	public Aluno(Integer id, String nome, String cpf, Modalidade modalidade, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.modalidade = modalidade;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(cpf, other.cpf) && modalidade == other.modalidade;
	}
	
	

	@Override
	public String toString() {
StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Id: " + this.getId());
		stringBuilder.append(", Nome: " + this.getNome());
		stringBuilder.append(" Cpf: " + this.getCpf());
		stringBuilder.append(" Modalidade: " + this.getModalidade());
		stringBuilder.append(", Telefone: " + this.getTelefone());
		
		return stringBuilder.toString();
	}
	
	
	
}

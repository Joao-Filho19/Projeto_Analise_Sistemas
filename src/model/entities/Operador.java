package model.entities;

import java.io.Serializable;
import java.util.Objects;

import model.entities.enums.Modalidade;

public class Operador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String cpf;
	private String senha;
	
	public Operador() {
		
	}

	public Operador(Integer id,String cpf,String senha) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
	Operador other = (Operador) obj;
		return  Objects.equals(cpf, other.cpf) && Objects.equals(senha, other.senha);
	}
	

	@Override
	public String toString() {
StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Id: " + this.getId());
		stringBuilder.append(" Cpf: " + this.getCpf());
		stringBuilder.append(", Senha: " + this.getSenha());
		
		return stringBuilder.toString();
	}
	
}

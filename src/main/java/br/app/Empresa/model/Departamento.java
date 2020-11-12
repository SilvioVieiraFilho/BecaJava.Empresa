package br.app.Empresa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String nome;

	
	
	
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

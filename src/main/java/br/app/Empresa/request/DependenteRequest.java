package br.app.Empresa.request;

import br.app.Empresa.model.Funcionario;

public class DependenteRequest {
	
	private String nome;
	
	private Funcionario funcionario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
	
	

}

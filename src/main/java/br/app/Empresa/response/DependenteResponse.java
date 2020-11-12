package br.app.Empresa.response;

import br.app.Empresa.model.Funcionario;

public class DependenteResponse extends BaseResponse {

	private Long id;
    private String nome;
    private Funcionario funcionario; 
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

package br.app.Empresa.response;

import java.util.List;

import br.app.Empresa.model.Dependente;

public class DependenteListResponse extends BaseResponse {
	
	
	private List<Dependente> dependente;

	public List<Dependente> getDependente() {
		return dependente;
	}

	public void setDependente(List<Dependente> dependente) {
		this.dependente = dependente;
	}
	
	
	
	
	
	

}

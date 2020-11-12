package br.app.Empresa.response;

import java.util.List;

import br.app.Empresa.model.Funcionario;

public class FuncionarioListResponse extends BaseResponse {

	private List<Funcionario> funcionario;

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}



}

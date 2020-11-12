package br.app.Empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.Empresa.model.Funcionario;

import br.app.Empresa.repository.FuncionarioRepository;
import br.app.Empresa.request.FuncionarioRequest;
import br.app.Empresa.response.BaseResponse;
import br.app.Empresa.response.FuncionarioListResponse;

import br.app.Empresa.response.FuncionarioResponse;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository repository;

	public BaseResponse inserir(FuncionarioRequest funcionariorequest) {

		BaseResponse response = new BaseResponse();
		Funcionario funcionario = new Funcionario();

		funcionario.setNome(funcionariorequest.getNome());
		funcionario.setEmail(funcionariorequest.getEmail());
		funcionario.setSalario(funcionariorequest.getSalario());
		funcionario.setTelefone(funcionariorequest.getTelefone());
		funcionario.setDepartamento(funcionariorequest.getDepartamento());

		repository.save(funcionario);

		response.message = "funcionario registrado";
		response.statusCode = 201;

		return response;

	}

	public FuncionarioResponse obter(Long id) {

		Optional<Funcionario> Funcionario = repository.findById(id);

		FuncionarioResponse response = new FuncionarioResponse();

		response.setNome(Funcionario.get().getNome());
		response.setEmail(Funcionario.get().getEmail());
		response.setSalario(Funcionario.get().getSalario());
		response.setTelefone(Funcionario.get().getTelefone());
		response.setDepartamento(Funcionario.get().getDepartamento());

		response.message = "Funcionario obtido com sucesso";
		response.statusCode = 200;

		return response;

	}

	public FuncionarioListResponse listar() {

		List<Funcionario> lista = repository.findAll();

		FuncionarioListResponse response = new FuncionarioListResponse();

		response.setFuncionario(lista);
		response.statusCode = 200;
		response.message = "Serviços obtidos com sucesso.";

		return response;

	}

}

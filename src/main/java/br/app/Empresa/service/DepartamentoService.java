package br.app.Empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.Empresa.model.Departamento;
import br.app.Empresa.repository.DepartamentoRepository;
import br.app.Empresa.request.DepartamentoRequest;
import br.app.Empresa.response.BaseResponse;
import br.app.Empresa.response.DepartamentoListResponse;
import br.app.Empresa.response.DepartamentoResponse;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;

	public BaseResponse inserir(DepartamentoRequest departamentoRequest) {

		BaseResponse response = new BaseResponse();

		Departamento departamento = new Departamento();

		departamento.setNome(departamentoRequest.getNome());

		repository.save(departamento);

		response.message = "departamento salvo";
		response.statusCode = 200;

		return response;

	}

	public DepartamentoResponse obter(Long id) {

		Optional<Departamento> departamento = repository.findById(id);

		DepartamentoResponse response = new DepartamentoResponse();

		response.setNome(departamento.get().getNome());

		response.message = "Departamento obtido com sucesso";
		response.statusCode = 200;

		return response;

	}

	public DepartamentoListResponse listar() {

		List<Departamento> lista = repository.findAll();

		DepartamentoListResponse response = new DepartamentoListResponse();

		response.setDepartamento(lista);
		response.statusCode = 200;
		response.message = "Serviços obtidos com sucesso.";

		return response;

	}

}

package br.app.Empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.app.Empresa.model.Dependente;
import br.app.Empresa.repository.DependenteRepository;
import br.app.Empresa.request.DependenteRequest;
import br.app.Empresa.response.BaseResponse;
import br.app.Empresa.response.DepartamentoListResponse;
import br.app.Empresa.response.DependenteListResponse;
import br.app.Empresa.response.DependenteResponse;

@Repository
public class DependenteService {

	@Autowired
	private DependenteRepository repository;

	public BaseResponse inserir(DependenteRequest dependentereque) {

		BaseResponse response = new BaseResponse();

		Dependente dependente = new Dependente();

		dependente.setNome(dependentereque.getNome());
		dependente.setFuncionario(dependentereque.getFuncionario());

		repository.save(dependente);

		response.message = "Dependente salvo";
		response.statusCode = 200;

		return response;

	}
	
	
	
	public DependenteResponse obter(Long id) {

		Optional<Dependente> dependente = repository.findById(id);

		DependenteResponse response = new DependenteResponse();

		response.setNome(dependente.get().getNome());
        response.setFuncionario(dependente.get().getFuncionario());
		response.message = "Departamento obtido com sucesso";
		response.statusCode = 200;

		return response;

	}
	
	
	
	public DependenteListResponse listar() {
 
		List<Dependente> lista = repository.findAll();

		DependenteListResponse response = new DependenteListResponse();

		response.setDependente(lista);
		response.statusCode = 200;
		response.message = "Serviços obtidos com sucesso.";

		return response;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

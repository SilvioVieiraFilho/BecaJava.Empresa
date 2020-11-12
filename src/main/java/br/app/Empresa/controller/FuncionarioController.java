package br.app.Empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.Empresa.request.FuncionarioRequest;
import br.app.Empresa.response.BaseResponse;
import br.app.Empresa.response.FuncionarioListResponse;
import br.app.Empresa.response.FuncionarioResponse;
import br.app.Empresa.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController extends BaseController {
	@Autowired
	private FuncionarioService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody FuncionarioRequest request) {
		try {
			BaseResponse response = service.inserir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping(path = "/{id}")

	public ResponseEntity obter(@PathVariable Long id) {
		try {

			FuncionarioResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping

	public ResponseEntity listar() {
		try {
			FuncionarioListResponse response = service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}

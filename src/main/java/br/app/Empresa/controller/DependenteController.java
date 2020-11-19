package br.app.Empresa.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.Empresa.Config.MessagingConfig;
import br.app.Empresa.request.DependenteRequest;
import br.app.Empresa.response.BaseResponse;
import br.app.Empresa.response.DependenteListResponse;
import br.app.Empresa.response.DependenteResponse;
import br.app.Empresa.service.DependenteService;

@RestController
@RequestMapping("/Dependente")
public class DependenteController extends BaseController {
	@Autowired
	private DependenteService service;



	@PostMapping
	public ResponseEntity inserir(@RequestBody DependenteRequest request) {
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

			DependenteResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping

	public ResponseEntity listar() {
		try {
			DependenteListResponse response = service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}

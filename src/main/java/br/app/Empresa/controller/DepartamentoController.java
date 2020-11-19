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
import br.app.Empresa.request.DepartamentoRequest;
import br.app.Empresa.response.BaseResponse;
import br.app.Empresa.response.DepartamentoListResponse;
import br.app.Empresa.response.DepartamentoResponse;
import br.app.Empresa.service.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController extends BaseController {
	@Autowired
	private DepartamentoService service;
	
    @Autowired
    private RabbitTemplate template;

	@PostMapping
	public ResponseEntity inserir(@RequestBody DepartamentoRequest request) {
		try {
			BaseResponse response = service.inserir(request);
			
			template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,service.inserir(request)) ;
			
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping(path = "/{id}")

	public ResponseEntity obter(@PathVariable Long id) {
		try {

			DepartamentoResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping

	public ResponseEntity listar() {
		try {
			DepartamentoListResponse response = service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}

package br.app.Empresa.controller;

import br.app.Empresa.response.BaseResponse;

public class BaseController {

	public BaseResponse errorBase = new BaseResponse();

	public BaseController() {
		errorBase.statusCode = 500;
		errorBase.message = "Ocorreu um erro inesperado. Contate o administrador";

	}
}

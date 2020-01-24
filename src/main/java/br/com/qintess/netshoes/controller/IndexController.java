package br.com.qintess.netshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.qintess.netshoes.respository.ClienteRespository;

@RestController
public class IndexController {
	
	@Autowired
	private ClienteRespository clienteRepository;
	
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String index() {
		
		return "Bem vindo a API Livraria 1.0";
	}
}

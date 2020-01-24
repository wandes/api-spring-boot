package br.com.qintess.netshoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.qintess.netshoes.model.Cliente;
import br.com.qintess.netshoes.respository.ClienteRespository;

@RestController
@RequestMapping(value="/api")
public class ClienteController {

	@Autowired
	private ClienteRespository clienteRepository;

	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public Cliente Post(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	@CrossOrigin(origins = "http://localhost:4200" )
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public List<Cliente> GetCustomers() {

		return clienteRepository.findAll();
	}

	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> GetById(@PathVariable(value = "id") long id) {
		java.util.Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent())
			return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

//	@RequestMapping(value = "/api/cliente/clientes/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Cliente> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Cliente newPessoa) {
//		Optional<Cliente> oldPessoa = clienteRepository.findById(id);
//		if (oldPessoa.isPresent()) {
//			Pessoa pessoa = oldPessoa.get();
//			pessoa.setNome(newPessoa.getNome());
//			clienteRepository.save(pessoa);
//			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
	
	 	@RequestMapping(value = "/clientes/cliente/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        java.util.Optional<Cliente> cliente = clienteRepository.findById(id);
	        if(cliente.isPresent()){
	        	clienteRepository.delete(cliente.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

}

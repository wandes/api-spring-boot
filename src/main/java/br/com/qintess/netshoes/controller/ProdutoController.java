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
import br.com.qintess.netshoes.model.Produto;
import br.com.qintess.netshoes.respository.ProdutoRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )
@RequestMapping(value="/api")
public class ProdutoController  {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public List<Produto> produtos() {

		return produtoRepository.findAll();
	}
}
}
}
	
	@RequestMapping(value = "/produto", method = RequestMethod.POST)
	public Produto Post(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}

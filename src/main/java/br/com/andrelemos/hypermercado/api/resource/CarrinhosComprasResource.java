package br.com.andrelemos.hypermercado.api.resource;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrelemos.hypermercado.api.event.RecursoCriadoEvent;
import br.com.andrelemos.hypermercado.api.model.CarrinhoCompras;
import br.com.andrelemos.hypermercado.api.model.CarrinhoItem;
import br.com.andrelemos.hypermercado.api.model.Produto;
import br.com.andrelemos.hypermercado.api.service.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping("/v1/produtos/carrinho")
public class CarrinhosComprasResource {

	@Autowired
	private ProdutoService service;

	@Autowired
	private CarrinhoCompras carrinho;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping("/{codigo}")
	public ResponseEntity<CarrinhoCompras> criar(@PathVariable Long codigo, HttpServletResponse response) {
		CarrinhoItem carrinhoItem = this.criaItem(codigo);
		carrinho.add(carrinhoItem);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, codigo));
		return ResponseEntity.status(HttpStatus.CREATED).body(carrinho);
	}
	
	@GetMapping
	public CarrinhoCompras carrinho(){
	    return carrinho;
	}

	private CarrinhoItem criaItem(Long produtoId) {
		Produto produto = service.buscaPorCodigo(produtoId);
		CarrinhoItem carrinhoItem = new CarrinhoItem(produto);
		return carrinhoItem;
	}
}

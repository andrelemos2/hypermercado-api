package br.com.andrelemos.hypermercado.api.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import br.com.andrelemos.hypermercado.api.model.Produto;
import br.com.andrelemos.hypermercado.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.andrelemos.hypermercado.api.event.RecursoCriadoEvent;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto, HttpServletResponse response) {
		Produto produtoSalvo = service.salvar(produto);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}

	@GetMapping
	public List<Produto> listarTodos() {
		return service.buscarTodos();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable Long codigo) {
		Produto produto = service.buscaPorCodigo(codigo);
		return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		service.apagarPorCodigo(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long codigo, @Valid @RequestBody Produto produto) {
		Produto produtoSalvo = service.atualizar(codigo, produto);
		return ResponseEntity.ok(produtoSalvo);
	}
	
	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		service.atualizarPropriedadeAtivo(codigo, ativo);
	}

}

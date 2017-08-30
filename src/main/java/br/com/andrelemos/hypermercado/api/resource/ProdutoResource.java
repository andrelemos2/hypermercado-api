package br.com.andrelemos.hypermercado.api.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import br.com.andrelemos.hypermercado.api.model.Produto;
import br.com.andrelemos.hypermercado.api.repository.ProdutoRepository;
import br.com.andrelemos.hypermercado.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrelemos.hypermercado.api.event.RecursoCriadoEvent;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto, HttpServletResponse response) {
		Produto produtoSalvo = produtoService.salvar(produto);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}

	@GetMapping
	public List<Produto> listarTodos() {
		return produtoService.buscarTodos();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable Long codigo) {
		Produto produto = produtoService.buscaPorCodigo(codigo);
		return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		produtoService.apagarPorCodigo(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long codigo, @Valid @RequestBody Produto produto) {
		Produto produtoSalvo = produtoService.atualizar(codigo, produto);
		return ResponseEntity.ok(produtoSalvo);
	}
	
	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		produtoService.atualizarPropriedadeAtivo(codigo, ativo);
	}

}

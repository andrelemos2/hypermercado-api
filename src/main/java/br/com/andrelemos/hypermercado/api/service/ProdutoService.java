package br.com.andrelemos.hypermercado.api.service;

import br.com.andrelemos.hypermercado.api.model.Produto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.andrelemos.hypermercado.api.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto atualizar(Long codigo, Produto produto) {
		Produto produtoSalvo = buscarProdutoPeloCodigo(codigo);
		
		BeanUtils.copyProperties(produto, produtoSalvo, "codigo");
		return produtoRepository.save(produtoSalvo);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Produto produtoSalvo = buscarProdutoPeloCodigo(codigo);
		produtoSalvo.setAtivo(ativo);
		produtoRepository.save(produtoSalvo);
	}
	
	private Produto buscarProdutoPeloCodigo(Long codigo) {
		Produto produtoSalvo = produtoRepository.findOne(codigo);
		if (produtoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return produtoSalvo;
	}

	public Produto buscaPorCodigo(Long codigo) {
		return produtoRepository.findOne(codigo);
	}

	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}

	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void apagarPorCodigo(Long codigo) {
		produtoRepository.delete(codigo);
	}
}

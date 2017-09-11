package br.com.andrelemos.hypermercado.api.model;

import java.math.BigDecimal;

public class CarrinhoItem {

	private Produto produto;

	public CarrinhoItem(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public BigDecimal getPreco(){
	    return produto.getValor();
	}
	
	public BigDecimal getTotal(int quantidade) {
	    return this.getPreco().multiply(new BigDecimal(quantidade));
	}

}

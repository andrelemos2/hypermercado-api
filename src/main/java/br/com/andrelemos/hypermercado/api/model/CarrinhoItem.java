package br.com.andrelemos.hypermercado.api.model;

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
}

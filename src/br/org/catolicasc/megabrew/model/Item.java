package br.org.catolicasc.megabrew.model;

public class Item {

	private Produto produto;
	private int qtd;
	private double preco;
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public double getPreco() {
		preco = produto.getPreco() * qtd;
		return preco;
	}
	/*
	public void setPreco(double preco) {
		this.preco = produto.getPreco() * qtd;
	}
	*/
		
}

package br.org.catolicasc.megabrew.model;


public class Estoque {
	
	private int qtd;
	private Produto produto;
		
	
	public Estoque() {};
	
	public Estoque(int qtd, Produto produto) {
		super();
		this.qtd = qtd;
		this.produto = produto;
	}



	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto p) {
		this.produto = p;
	}
	
}

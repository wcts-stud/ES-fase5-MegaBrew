package br.org.catolicasc.megabrew.model;

public class Produto {

	private int id_produto;
	private String nome;
	private String descricao;
	private double preco;
	
	
	public Produto() {};
	
	public Produto(int id, String nome, String descricao, double preco) {
		super();
		this.id_produto = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	
	public int getId() {
		return id_produto;
	}
	public void setId(int id) {
		this.id_produto = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}

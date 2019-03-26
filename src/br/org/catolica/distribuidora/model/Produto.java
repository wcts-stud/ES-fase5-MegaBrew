package br.org.catolica.distribuidora.model;

import java.util.List;

public class Produto {
	private String nome;
	private String validade;
	private String descricao;
	private String unidadeMedida;
	private Double volume;
	private int cod;
	private double quantidade;
	private double preco;
	private List<String> ingradientes;
	
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public List<String> getIngradientes() {
		return ingradientes;
	}
	
	public void setIngradientes(List<String> ingradientes) {
		this.ingradientes = ingradientes;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}

	
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}

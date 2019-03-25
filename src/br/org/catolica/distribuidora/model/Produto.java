package br.org.catolica.distribuidora.model;

import java.util.List;

public class Produto {
	private String Nome;
	private String validade;
	private String Descricao;
	private String UnidadeMedida;
	private Double volume;
	private int cod;
	private int quantidade;
	private Double preco;
	private List<String> ingradientes;
	
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
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
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public String getUnidadeMedida() {
		return UnidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		UnidadeMedida = unidadeMedida;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}

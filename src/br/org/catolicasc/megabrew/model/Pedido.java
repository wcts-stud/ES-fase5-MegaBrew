package br.org.catolicasc.megabrew.model;

import java.util.List;

public class Pedido {

	private int id_pedido;
	private List<Item> itensPedido;	
	
	
	public int getNumero() {
		return id_pedido;
	}
	public void setNumero(int numero) {
		this.id_pedido = numero;
	}
	
	public List<Item> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<Item> itensPedido) {
		this.itensPedido = itensPedido;
	}	
	
}

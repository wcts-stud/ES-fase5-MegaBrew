package br.org.catolica.distribuidora.model;

import java.util.List;

public class Pedido {
		private int id;
		private Item item;
		private double valorTotal;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Item getItem() {
			return item;
		}
		public void setItem(Item item) {
			this.item = item;
		}
		public double getValorTotal() {
			return valorTotal;
		}
		public void setValorTotal(double valorTotal) {
			this.valorTotal = valorTotal;
		}	

}

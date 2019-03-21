package br.org.catolicasc.megabrew.dao;

import java.util.ArrayList;
import java.util.List;

import br.org.catolicasc.megabrew.model.Pedido;
import br.org.catolicasc.megabrew.model.Produto;


public class PedidoDAO {

	private static List<Pedido> itensPedido = 
			new ArrayList<Pedido>();
	
	static {
		/*
		 * Adicionar vários pedidos, cada pedido
		 * 	tem seus itens;
		 */
		Pedido pedido = new Pedido();
		Produto produto = new Produto();
		List<Produto> p = new ArrayList<Produto>();
		
		produto.setId(1);
		produto.setNome("Produto do pedido");
		produto.setDescricao("Descrição do produto do pedido");
		p.add(produto);		
		
		produto.setId(2);
		produto.setNome("Outro produto do pedido");
		produto.setDescricao("Descricao do outro produto do pedido");
		p.add(produto);
				
		pedido.setNumero(001);
		pedido.setItensPedido(p);
		pedido.setQtd(1);

		/* Se não tiver a quantidade em estoque, cancela
		 * 	o pedido e retorna ao usuário;
		 */
		
		itensPedido.add(pedido);
	}
	
	
}

package br.org.catolicasc.megabrew.dao;

import br.org.catolicasc.megabrew.model.Item;
import br.org.catolicasc.megabrew.model.Produto;

public class ItemDAO {
	
	static {
		Produto produto = new Produto(001, "Leite", "Leite integral desnatado", 2.5);
		
		Item i = new Item();
		i.setProduto(produto);
		i.setQtd(2);
	}

}

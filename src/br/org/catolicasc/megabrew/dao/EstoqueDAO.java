package br.org.catolicasc.megabrew.dao;

import java.util.ArrayList;
import java.util.List;

import br.org.catolicasc.megabrew.model.Estoque;
import br.org.catolicasc.megabrew.model.Produto;

public class EstoqueDAO {
	
	private static List<Estoque> itensEstoque = new ArrayList<Estoque>();
	
		
	
	static {
		Estoque e = new Estoque();
		Produto p = new Produto();
		
		p.setId(1);
		p.setNome("Aveia");
		p.setDescricao("Aveia de maça e mel");
		e.setProduto(p);
		e.setQtd(20);
		itensEstoque.add(e);
		
		
		//p.setId(2);
		//p.setNome("Leite");
		//p.setDescricao("Leite Integral");
		//e.setProduto(p);
		//e.setQtd(3);
		//itensEstoque.add(e);
	}
	
	
	
	public static List<Estoque> GetItens() {
		return itensEstoque;
	}

}

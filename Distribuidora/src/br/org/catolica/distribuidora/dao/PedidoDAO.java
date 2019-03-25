package br.org.catolica.distribuidora.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.org.catolica.distribuidora.model.Pedido;
import br.org.catolica.distribuidora.model.Produto;


public class PedidoDAO {
	
	private static List<Produto> Produtos = 
			new ArrayList<Produto>();
	
	private static List<Pedido> Pedidos = 
			new ArrayList<Pedido>();

	
	
	static {
		Produto produto = new Produto();
		produto.setCod(1);
		produto.setNome("Brahma");
		produto.setValidade("02/04/2020");
		produto.setDescricao("Brahma é uma marca de cerveja brasileira criada em 1888, "
		+ "no Rio de Janeiro, pela Manufactura de Cerveja Brahma Villiger & Companhia, "
		+ "que depois mudaria de nome para Companhia Cervejaria Brahma, e depois seria "
		+ "sucedida pela AmBev.");
		produto.setUnidadeMedida("ml");
		produto.setVolume(350.0);
		produto.setQuantidade(15);
		produto.setPreco(24.54);		
		produto.setIngradientes(Arrays.asList("Trigo"));
		
		Produtos.add(produto);
		
		Produto produto2 = new Produto();
		produto.setCod(2);
		produto2.setNome("Stella");
		produto2.setValidade("05/12/2020");
		produto2.setDescricao("A Stella Artois é uma cerveja pilsner lager premium, que "
		+ "tem suas origens em uma tradicional cervejaria chamada Den Hoorn, que "
		+ "data em 1366, uma das mais antigas do mundo.");
		produto2.setUnidadeMedida("ml");
		produto2.setVolume(600.0);
		produto2.setQuantidade(50);
		produto2.setPreco(44.00);				
		produto2.setIngradientes(Arrays.asList("Trigo", "Água", ", Malte", "Lúpulo"));
		Produtos.add(produto2);
		
		Produto produto3 = new Produto();
		produto.setCod(3);
		produto3.setNome("Dado Bier");
		produto3.setValidade("03/08/2020");
		produto3.setDescricao("A Dado Bier é a primeira cervejaria brasileira a seguir "
		+ "o Reinheitsgebot, Decreto de Pureza da Baviera, criado em 1516 para "
		+ "disciplinar a produção cervejeira na Alemanha.");
		produto3.setUnidadeMedida("L");
		produto3.setVolume(1.0);
		produto3.setQuantidade(100);
		produto3.setPreco(50.0);				
		produto3.setIngradientes(Arrays.asList("Trigo"));
		Produtos.add(produto3);
		
	}
	
	
	public static List<Produto>ObterProdutos(){
		return Produtos;
	}

	public static void inserirProduto(Produto produto) {
		Produtos.add(produto);		
	}

	// Pesquisa pelo codigo do produto
	public static Produto pesquisaProdutoPorId(int cod) {		
		Produto p = new Produto();
		
		for(int i=0; i < Produtos.size(); i++) {
			//System.out.println("Produto " + i + ": " + Produtos.get(i).getCod());
			
			if ( Produtos.get(i).getCod() == cod ) {
				p = Produtos.get(i);
			}
			
		}		
		return p;
	}
	
	
	
	public static List<Pedido>ObterPedidos(){
		return Pedidos;
	}

	public static void CriarPedido(Pedido pedido) {
		Pedidos.add(pedido);		
	}	
	
}

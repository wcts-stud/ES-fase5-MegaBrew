package br.org.catolica.distribuidora.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.org.catolica.distribuidora.exception.semEstoqueException;
import br.org.catolica.distribuidora.exception.semItensNoPedidoException;
import br.org.catolica.distribuidora.model.Item;
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
		produto.setPreco(50.0);
		produto.setIngradientes(Arrays.asList("Trigo"));
		
		Produtos.add(produto);
		
		Produto produto2 = new Produto();
		produto2.setCod(2);
		produto2.setNome("Stella");
		produto2.setValidade("05/12/2020");
		produto2.setDescricao("A Stella Artois é uma cerveja pilsner lager premium, que "
		+ "tem suas origens em uma tradicional cervejaria chamada Den Hoorn, que "
		+ "data em 1366, uma das mais antigas do mundo.");
		produto2.setUnidadeMedida("ml");
		produto2.setVolume(600.0);
		produto2.setQuantidade(50);
		produto2.setPreco(50.00);				
		produto2.setIngradientes(Arrays.asList("Trigo", "Água", ", Malte", "Lúpulo"));
		Produtos.add(produto2);
		
		Produto produto3 = new Produto();
		produto3.setCod(3);
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
	
	// Pesquisa pela descricao do produto
	public static Produto pesquisaProdutoPorDesc(String descricao) {		
		Produto p = new Produto();
		
		for(int i=0; i < Produtos.size(); i++) {
			
			if ( Produtos.get(i).getDescricao().toLowerCase().contains(descricao.toLowerCase()) ) {
				p = Produtos.get(i);		
			}
			
		}		
		return p;
	}
	
	
	
	public static List<Pedido>ObterPedidos(){
		return Pedidos;
	}

	
	public static void CriarPedido(Pedido pedido) throws semItensNoPedidoException, semEstoqueException {

		double total = 0;
		
		
		if( pedido.getItens().size() > 0 ) {
			
			// Verifica itens do pedido
			for (Item i : pedido.getItens()) {
				
				// Verifica estoque e valor dos produtos da lista de produtos
				for(Produto p : Produtos) {
					
					// Compara o produto do item com os produtos da lista
					if (i.getProduto().getCod() == p.getCod()) {
						i.setProduto(p);
						
						// Verificar quantidade disponivel em estoque
						if(i.getQtd() > p.getQuantidade()) {
							throw new semEstoqueException();
						} else {
							p.setQuantidade( (p.getQuantidade() - i.getQtd()) ); 
						}						
					}
					
					total = p.getPreco() * i.getQtd();
					i.setValorItem(total);					
				}
			}
			
			pedido.setValorTotal(total);
			
			Pedidos.add(pedido);
				
		} else {
			throw new semItensNoPedidoException();
		}
	}	
	
}

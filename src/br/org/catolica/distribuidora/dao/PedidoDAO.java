package br.org.catolica.distribuidora.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.org.catolica.distribuidora.exception.semEstoqueException;
import br.org.catolica.distribuidora.exception.semItensNoPedidoException;
import br.org.catolica.distribuidora.model.Item;
import br.org.catolica.distribuidora.model.Pedido;
import br.org.catolica.distribuidora.model.Produto;
import br.org.catolica.distribuidora.model.Usuario;


public class PedidoDAO {
	
	private static List<Produto> Produtos = 
			new ArrayList<Produto>();
	
	private static List<Item> itens = 
			new ArrayList<Item>();
	
	private static List<Pedido> pedidos = 
			new ArrayList<Pedido>();


	private static List<Usuario> Users = new ArrayList<Usuario>();
	
	
	static {
			// PRODUTO //
		Produto produto1 = new Produto();
		produto1.setCod(1);
		produto1.setNome("Brahma");
		produto1.setValidade("02/04/2020");
		produto1.setDescricao("Brahma é uma marca de cerveja brasileira criada em 1888, "
		+ "no Rio de Janeiro, pela Manufactura de Cerveja Brahma Villiger & Companhia, "
		+ "que depois mudaria de nome para Companhia Cervejaria Brahma, e depois seria "
		+ "sucedida pela AmBev.");
		produto1.setUnidadeMedida("ml");
		produto1.setVolume(350.0);
		produto1.setQuantidade(15);
		produto1.setPreco(50.0);
		produto1.setIngradientes(Arrays.asList("Trigo"));
		
		Produtos.add(produto1);
		
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
		produto2.setIngradientes(Arrays.asList("Trigo", "Água", "Malte", "Lúpulo"));
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
		
		
			// ITEM //
		
		Item item1 = new Item();
		item1.setProduto(produto1);
		item1.setQtd(3);
		//item1.setValorItem(produto1.getPreco() * item1.getQtd());
		itens.add(item1);
		
		Item item2 = new Item();
		item2.setProduto(produto2);
		item2.setQtd(2);
		itens.add(item2);

		
			// USUARIOS //
		
		Usuario user1 = new Usuario();		
		user1.setNome("cat");
		user1.setDataNascimento(new Date());
		user1.setLogin(user1.generateUser(user1.getNome()));
		user1.setPassword("cat");
		
		
		Usuario user2 = new Usuario();
		user2.setNome("Usuario Pad");
		user2.setDataNascimento(new Date());
		user2.setLogin(user1.generateUser(user2.getNome()));
		user2.setPassword("1234");		
		Users.add(user2);
		
		
			// PEDIDOS //
		
		Pedido pedido1 = new Pedido();
		pedido1.setId(1);
		pedido1.setItens(itens);
		pedido1.setValorTotal(500);
		pedidos.add(pedido1);
		
		user1.setPedidos(pedidos);
		Users.add(user1);
		
	}
	
	
	/*
	 * 			Métodos
	 */
	
		// PRODUTOS //
	
	public static List<Produto> obterProdutos(){
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
	
	
	
		// PEDIDO //
	
	public static List<Pedido> listarPedidos(){
		return pedidos;
	}

	
	
	public static void criarPedido(Pedido pedido, Usuario usuario) throws semItensNoPedidoException, semEstoqueException {

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
			
			pedidos.add(pedido);
			
			// Add pedido ao usuário
			usuario.setPedidos(pedidos);
				
		} else {
			throw new semItensNoPedidoException();
		}
	}
	
	
	
		// USUARIOS //

	public static List<Usuario> listarUsuarios() {
		return Users;
	}


	// Inserir usuarios
	public static void inserirUsuario(Usuario newUser) {
		Users.add(newUser);
	}


	// Pesquisar usuários
	public static List<Pedido> pesquisarUsuario(String user) {		
		Usuario u = new Usuario();

		//for(Usuario usuario : users)
		for(int i= Users.size()-1; i >= 0; i--) {

			if( Users.get(i).getNome().equals(user) || 
					Users.get(i).getLogin().equals(user)) {

				u = Users.get(i);
			}
		}
		
		return u.getPedidos();
	}
	
}

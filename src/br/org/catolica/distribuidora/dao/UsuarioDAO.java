package br.org.catolica.distribuidora.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.org.catolica.distribuidora.exception.semEstoqueException;
import br.org.catolica.distribuidora.exception.semItensNoPedidoException;
import br.org.catolica.distribuidora.model.Cliente;
import br.org.catolica.distribuidora.model.Item;
import br.org.catolica.distribuidora.model.Pedido;
import br.org.catolica.distribuidora.model.Produto;
import br.org.catolica.distribuidora.model.Usuario;

public class UsuarioDAO {
	
	private static List<Usuario> Users = new ArrayList<Usuario>();
	private static List<Produto> Produtos = new ArrayList<Produto>();
	private static List<Pedido> Pedidos = new ArrayList<Pedido>();
	
	
		// Listar usuarios
	public static List<Usuario> listarUsuarios() {
		return Users;
	}
	

	
	// Inserir usuarios
	public static void inserirUsuario(Usuario newUser) {
		
		//if( !newUser.getLogin().isEmpty() && !newUser.getNome().isEmpty() ) {
		//newUser.setLogin(newUser.generateUser(newUser.getNome()));
		Users.add(newUser);
		//}
	}
	
	
	
	// Pesquisar usuários
	public static Usuario pesquisarUsuario(String user) {
		Usuario u = new Usuario();

		//for(Usuario usuario : users)
		for(int i= Users.size(); i > 0; i++) {
			
			if( Users.get(i).getNome().equals(user) || 
					Users.get(i).getLogin().equals(user)) {
				
				u = Users.get(i);
			}
		}
		
		return u; 
	}

}

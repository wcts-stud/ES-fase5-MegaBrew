package br.org.catolica.distribuidora.service;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import br.org.catolica.distribuidora.dao.PedidoDAO;
import br.org.catolica.distribuidora.exception.UsuarioJaExisteException;
import br.org.catolica.distribuidora.exception.UsuarioNaoAutenticadoException;
import br.org.catolica.distribuidora.exception.semEstoqueException;
import br.org.catolica.distribuidora.exception.semItensNoPedidoException;
import br.org.catolica.distribuidora.model.Pedido;
import br.org.catolica.distribuidora.model.Produto;
import br.org.catolica.distribuidora.model.Usuario;


@WebService
public class ProdutoService {	
	
		// PRODUTOS //
	
	public List<Produto> listarProdutos(){
		return PedidoDAO.obterProdutos();
	}
	
	public List<Pedido> listaTodosPedidos(){
		return PedidoDAO.listarPedidos();
	}
	
	
		// USUARIOS //
	
	public List<Usuario> listarUsuarios() {
		return PedidoDAO.listarUsuarios();
	}
	
	
	/*
	 * INSERÇÕES
	 */
	
	public void inserirProduto(@WebParam (name="cerveja") Produto produto, 
	@WebParam (name="usuario", header=true) Usuario usuario)  throws UsuarioNaoAutenticadoException {
		
		for(Usuario user : listarUsuarios())
		if(user.getLogin().equals(usuario.getLogin()) && 
				user.getPassword().equals(usuario.getPassword())) {			
			
			PedidoDAO.inserirProduto(produto);			
		}else {
			
			throw new UsuarioNaoAutenticadoException();			
		}	
		
	}
	
	
	//public void inserirUsuario(@WebParam (name="Usuarios") Usuario usuario) throws UsuarioJaExisteException {

		//PedidoDAO.inserirUsuario(usuario);
		
	
		//if(pesquisaUsuario(usuario.getNome()) == null && pesquisaUsuario(usuario.getLogin()) == null) {
		//} else {
		//	throw new UsuarioJaExisteException();
		//}
		
	//}
	

	public void criarPedido(@WebParam (name="pedido") Pedido pedido, 
	@WebParam (name="usuario", header=true) Usuario usuario)  throws UsuarioNaoAutenticadoException, semItensNoPedidoException, semEstoqueException {
		
		Usuario cliente = null;
		
		for(Usuario user : listarUsuarios()) {
			if(user.getLogin().equals(usuario.getLogin()) && 
					user.getPassword().equals(usuario.getPassword())) {
				
				cliente = user;			
			}			
		}
	
		
		if(cliente != null) {			
			PedidoDAO.criarPedido(pedido , cliente);
			
		} else {
			throw new UsuarioNaoAutenticadoException();
		}
		
	}
	
	
	
	
	/*
	 * PESQUISAS
	 */

	public Produto pesquisarProdutoPorCodigo(@WebParam (name="codigoDoProduto", header=true) int cod) { 
		return PedidoDAO.pesquisaProdutoPorId(cod);
	}

	public Produto pesquisaProdutoPorDesc(@WebParam (name="descricaoDoProduto", header=true) String descricao) { 
		return PedidoDAO.pesquisaProdutoPorDesc(descricao);
	}
	
	public List<Pedido> pesquisaPedidosPorUsuario(@WebParam (name="NomeOuLoginDoUsuario", header=true) String usuario) {
		return PedidoDAO.pesquisarUsuario(usuario);
	}
	
	
	
			// MAIN //
		
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8181/produtos", new ProdutoService());
		System.out.println("Serviço iniciadoo! \n\t http://localhost:8181/produtos?wsdl");
		PedidoDAO.obterProdutos();
	}
	
}
package br.org.catolica.distribuidora.service;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import br.org.catolica.distribuidora.dao.PedidoDAO;
import br.org.catolica.distribuidora.model.Pedido;
import br.org.catolica.distribuidora.model.Produto;
import br.org.catolica.distribuidora.model.Usuario;
@WebService

public class ProdutoService {
	private static final String CAT = "cat";
	
	public List<Produto> listarProdutos(){
		return PedidoDAO.ObterProdutos();
	}
	
	public List<Pedido> listarPedidos(){
		return PedidoDAO.ObterPedidos();
	}
	
	
	public void inserirProduto(@WebParam (name="cerveja") Produto produto, 
	@WebParam (name="usuario", header=true) Usuario usuario)  throws UsuarioNaoAutenticadoException {
		
		if(CAT.equals(usuario.getLogin()) && 
				CAT.equals(usuario.getPassword())) {
			PedidoDAO.inserirProduto(produto);	
		}else {
			throw new UsuarioNaoAutenticadoException();
		}	
		
	}	

	public Produto pesquisarProduto(@WebParam (name="codigoDoProduto", header=true) int cod) { 
		return PedidoDAO.pesquisaProdutoPorId(cod);
	}
	
	
	public void criarPedido(@WebParam (name="pedido") Pedido pedido, 
	@WebParam (name="usuario", header=true) Usuario usuario)  throws UsuarioNaoAutenticadoException {
		if(CAT.equals(usuario.getLogin()) && 
				CAT.equals(usuario.getPassword())) {
			
			if( pedido.getItem().getQtd() >  )
				PedidoDAO.CriarPedido(pedido);
			
			
		}else {
			throw new UsuarioNaoAutenticadoException();
		}	
	}
	
	
	
	
		
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8181/produtos", new ProdutoService());
		System.out.println("Serviço iniciadoo! \n\t http://localhost:8181/produtos?wsdl");
		PedidoDAO.ObterProdutos();
	}
	
}
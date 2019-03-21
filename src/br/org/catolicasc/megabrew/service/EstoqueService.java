package br.org.catolicasc.megabrew.service;

import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import br.org.catolicasc.megabrew.dao.EstoqueDAO;
import br.org.catolicasc.megabrew.model.Estoque;

@WebService
public class EstoqueService {

	public List<Estoque> listar() {
		return EstoqueDAO.GetItens();
	}
	
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/megabrew/estoque", 
				new EstoqueService());
		
		System.out.println("Serviço iniciado...\n\t"
				+ "MegaBrew disponível\n\t\t"
				+ "insira no navegador: http://localhost:8081/megabrew/estoque?wsdl");
	}
	
}

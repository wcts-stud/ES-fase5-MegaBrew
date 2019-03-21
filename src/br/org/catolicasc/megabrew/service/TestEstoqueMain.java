package br.org.catolicasc.megabrew.service;

import java.util.Scanner;

import br.org.catolicasc.megabrew.model.Item;
import br.org.catolicasc.megabrew.model.Produto;

public class TestEstoqueMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int entrada;
		
		System.out.println("\t----- TESTE PEDIDO ------");
		System.out.println("[1]- Adicionar um item ao carrinho");
		entrada = input.nextInt(); 
		if (entrada != 1) {};
		
		System.out.println();
		
	}
}

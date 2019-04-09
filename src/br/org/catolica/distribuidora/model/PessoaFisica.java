package br.org.catolica.distribuidora.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlSeeAlso(Cliente.class)
@XmlAccessorType(XmlAccessType.FIELD) //Mapeia o XML pelos campos
public class PessoaFisica extends Cliente {
	
	private String CPF;

	
	public PessoaFisica() {}
	
	public PessoaFisica(String nome, Date dataNasc) {
		super(nome, dataNasc);
	}
	
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}	

}

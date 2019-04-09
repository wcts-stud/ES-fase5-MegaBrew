package br.org.catolica.distribuidora.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso(Cliente.class)
@XmlAccessorType(XmlAccessType.FIELD) //Mapeia o XML pelos campos
public class PessoaJuridica extends Cliente {
	
	private String CNPJ;

	
	public PessoaJuridica() {}
	
	public PessoaJuridica(String nome, Date dataNasc) {
		super(nome, dataNasc);
	}
	
	
	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}	

}

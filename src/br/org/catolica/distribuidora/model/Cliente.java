package br.org.catolica.distribuidora.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import br.org.catolica.distribuidora.util.AdaptadorData;

@XmlAccessorType(XmlAccessType.FIELD) //mapeia o XML pelos campos
public class Cliente {
	
	private String nome;
	@XmlJavaTypeAdapter(AdaptadorData.class)
	//@XmlTransient //oculta a informações
	private Date dataNascimento;
	
	
	public Cliente() {}
	
	public Cliente(String nome, Date dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}

package br.org.catolica.distribuidora.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name = "tipo")
public enum ClienteJuridico {

	@XmlEnumValue("bar")
	BAR, 
	
	@XmlEnumValue("pub")
	PUB, 
	
	@XmlEnumValue("restaurante")
	RESTAURANTE, 
	
	@XmlEnumValue("lanchonete")
	LANCHONETE
	
}

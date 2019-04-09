package br.org.catolica.distribuidora.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD) //mapeia o XML pelos campos
public class Usuario extends Cliente {
		
		private String login;
		private String password;

		//@XmlTransient //oculta a informações
		private List<Pedido> pedidos = new ArrayList<Pedido>();

		
		public Usuario() {}
		
		public Usuario(String nome, Date dataNasc) {
			super(nome, dataNasc);
			//this.login = generateUser(nome);
			
		}
		
		
		
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
			//generateUser(login);
		}
		
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}		
		
		
		public List<Pedido> getPedidos() {
			return pedidos;
		}
		public void setPedidos(List<Pedido> pedidos) {
			this.pedidos = pedidos;
		}



		public String generateUser(String name) {
			name = name.toLowerCase().replace(" ", ".");
			return name;
		}
		
}

package br.org.catolica.distribuidora.model;

public class Usuario {
		private String NomeCliente;
		
		public String getNomeCliente() {
			return NomeCliente;
		}
		public void setNomeCliente(String nomeCliente) {
			NomeCliente = nomeCliente;
		}
		private String login;
		private String password;

		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}

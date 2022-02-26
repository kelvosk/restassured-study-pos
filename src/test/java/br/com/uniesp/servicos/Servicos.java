package br.com.uniesp.servicos;

public enum Servicos {
	users_ID("/api/users/{id}"),
	getUsers_PAGE ("/api/users?page={id}"),
	getUnknown_PAGE ("/api/unknown"),
	getCreateUsersPage("/api/users");

	private final String valor;
	
	Servicos(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

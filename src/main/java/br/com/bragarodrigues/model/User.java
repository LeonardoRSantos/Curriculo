package br.com.bragarodrigues.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -1067813272360216451L;
	
	private String nome;
	private String senha;
	private String primeiroNome;
	private String ultimoNome;

	public User(String userName, String password, String firstName, String lastName) {
		this.nome = userName;
		this.senha = password;
		this.primeiroNome = firstName;
		this.ultimoNome = lastName;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	
	public String getUltimoNome() {
		return ultimoNome;
	}
	
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

}

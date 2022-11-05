package br.com.bragarodrigues.service;

import br.com.bragarodrigues.model.User;


public class LoginService {

	public User getUser(String userName) {
		//Let's use hardcoded data for demonstration purposes.
		if (userName.equalsIgnoreCase("admin")) {
			return new User("admin", "admin", "bragarodrigues", " Ao Site");
		} else {
			return null;
		}
	}
	
}

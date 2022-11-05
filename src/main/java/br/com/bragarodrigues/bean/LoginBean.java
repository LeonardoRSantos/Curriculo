package br.com.bragarodrigues.bean;

import br.com.bragarodrigues.model.User;
import br.com.bragarodrigues.service.LoginService;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named("loginBean")
@RequestScoped
public class LoginBean {

	@Inject
	private LoginService service;
	
	private String nomeUsuario;
	private String senha;

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String login() {
		System.out.println("LoginBean.login()");
		User user = this.service.getUser(this.nomeUsuario);

		if (user != null && user.getSenha().equals(this.senha)) {
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("user", user);
			return "success";
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales no válidas", "Credenciales no válidas");			
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "";
		}
	}

	public String logoff() {
		System.out.println("LoginBean.logoff()");
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.removeAttribute("user");
		return "success";
	}

}

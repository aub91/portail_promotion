package fr.afcepf.al32.groupe2.web.connexion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al32.groupe2.entity.User;
import fr.afcepf.al32.groupe2.service.IAuthenticationService;

@Component
@SessionScope
public class ConnectionBean {
	
	@Autowired
	private IAuthenticationService authenticationService;
	
	private User loggedUser;
	
	private String login;
	
	private String password;
	
	private String message;
	
	public String connect() {
		String suite="/invite/connexion/simpleConnexion";
		
		User newUser = authenticationService.findOneByLoginAndPassword(login, password);
		
		if(newUser != null) {
			loggedUser = newUser;
			suite = "/invite/fichesPromotion/pageAffichagePromotions";
			message = null;
		} else {
			message = "Informations de connexion incorrectes";
		}

		return suite;
	}
	
	public String logout() {
		loggedUser = null;
		
		return "/invite/fichesPromotion/pageAffichagePromotions";
	}

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

	public User getLoggedUser() {
		return loggedUser;
	}

	public String getMessage() {
		return message;
	}
	
	
}

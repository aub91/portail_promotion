package fr.afcepf.al32.groupe2.service;

import fr.afcepf.al32.groupe2.entity.User;

public interface IAuthenticationService {

	
	public User findOneByLoginAndPassword(String login, String password);

}

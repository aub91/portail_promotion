package fr.afcepf.al32.groupe2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.UserDao;
import fr.afcepf.al32.groupe2.entity.User;
import fr.afcepf.al32.groupe2.service.IAuthenticationService;

@Component
public class AuthenticationService implements IAuthenticationService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findOneByLoginAndPassword(String login, String password) {
		return userDao.findOneByLoginAndPassword(login, password);
	}

}

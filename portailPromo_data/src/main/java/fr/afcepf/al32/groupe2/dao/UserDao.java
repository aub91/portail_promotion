package fr.afcepf.al32.groupe2.dao;

import fr.afcepf.al32.groupe2.entity.User;

public interface UserDao {
	User findOneById(Long id);
	
	User findOneByLoginAndPassword(String login, String password);
}

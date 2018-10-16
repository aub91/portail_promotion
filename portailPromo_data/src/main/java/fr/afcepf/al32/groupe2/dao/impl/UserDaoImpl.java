package fr.afcepf.al32.groupe2.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.UserDao;
import fr.afcepf.al32.groupe2.entity.User;

@Component
@Transactional
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public User findOneById(Long id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

}

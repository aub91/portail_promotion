package fr.afcepf.al32.groupe2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.ClientDao;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.IFollowableElement;
import fr.afcepf.al32.groupe2.entity.User;

@Component
@Transactional
public class ClientDaoImpl implements ClientDao{

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAllFollowingFollowableElement(IFollowableElement element) {
		
//		Query query = em.createNamedQuery("Client.findAllFollowingFollowableElement");
		
		Query query = em.createNativeQuery("SELECT cli.id, cli.first_name, cli.last_name, cli.phone_number, cli.email FROM core_user as cli INNER JOIN following_element_data as fed ON cli.id = fed.subscriber_id WHERE cli.user_type = 'CLIENT' AND fed.element_id = 1 AND fed.element_type = 'CATEGORY' AND fed.follow_end_date IS NULL", User.class);
		
		List<User> res = query.getResultList();
		return null;
	}

}

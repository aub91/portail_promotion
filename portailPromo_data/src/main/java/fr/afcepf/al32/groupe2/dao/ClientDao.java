package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.IFollowableElement;

public interface ClientDao {
	List<Client> findAllFollowingFollowableElement(IFollowableElement element);
	public Client findOne(long  id);	
}

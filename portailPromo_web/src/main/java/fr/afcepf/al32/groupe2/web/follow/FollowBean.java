package fr.afcepf.al32.groupe2.web.follow;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Shop;
import fr.afcepf.al32.groupe2.service.IFollowableElementService;
import fr.afcepf.al32.groupe2.web.connexion.ConnectionBean;

@Component
@Transactional
@SessionScope
public class FollowBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ConnectionBean connectionBean;
	
	@Autowired
	private IFollowableElementService followableElementService;
	
	public void follow(Shop shop) {
		followableElementService.addSubscriber(shop, (Client) connectionBean.getLoggedUser());
	}
}

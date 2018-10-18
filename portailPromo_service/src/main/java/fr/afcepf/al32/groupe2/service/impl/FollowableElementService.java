package fr.afcepf.al32.groupe2.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.ClientDao;
import fr.afcepf.al32.groupe2.dao.FollowingElementDataDao;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.entity.IFollowableElement;
import fr.afcepf.al32.groupe2.entity.ISubscriber;
import fr.afcepf.al32.groupe2.service.IFollowableElementService;
import fr.afcepf.al32.groupe2.service.ISubscriberService;

@Component
@Transactional
public class FollowableElementService implements IFollowableElementService{
	
	@Autowired
	private FollowingElementDataDao followingElementDataDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private ISubscriberService subscriberService;

	@Override
	public FollowingElementData addSubscriber(IFollowableElement element, ISubscriber subscriber) {
		FollowingElementData followingElementData = new FollowingElementData();
		
		followingElementData.setElement(element);
		followingElementData.setElementType(element.getType());
		followingElementData.setSubscriber(subscriber);
		followingElementData.setSubscriberType(subscriber.getType());
		followingElementData.setFollowStartDate(new Date());
		
		return followingElementDataDao.save(followingElementData);
		
	}

	@Override
	public void notifySubscribers(IFollowableElement element) {
		List<Client> subscribers = getClientSubscribers(element);
		
		subscribers.forEach(subscriber -> subscriberService.update(subscriber, element));
	}

	@Override
	public void removeSubscriber(FollowingElementData followingElementData) {
		followingElementData.setFollowEndDate(new Date());
		
		followingElementDataDao.save(followingElementData);
		
	}
	
	public List<Client> getClientSubscribers(IFollowableElement element){
		return clientDao.findAllFollowingFollowableElement(element);
	}


}

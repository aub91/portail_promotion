package fr.afcepf.al32.groupe2.service;

import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.entity.IFollowableElement;
import fr.afcepf.al32.groupe2.entity.ISubscriber;

public interface IFollowableElementService {
	
	FollowingElementData addSubscriber(IFollowableElement element, ISubscriber subscriber);
	
	void removeSubscriber(FollowingElementData followingElementData);
	
	void notifySubscribers(IFollowableElement element);

}

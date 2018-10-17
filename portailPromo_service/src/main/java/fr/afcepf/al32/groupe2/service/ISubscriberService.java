package fr.afcepf.al32.groupe2.service;

import java.util.Map;

import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.entity.IFollowableElement;
import fr.afcepf.al32.groupe2.entity.ISubscriber;

public interface ISubscriberService {
	void update(ISubscriber subscriber, IFollowableElement element);
	
	Map<Long, FollowingElementData> getAllFollowableElementData(ISubscriber subscriber);
	
	Map<Long, FollowingElementData> getAllFollowableElementDataByElementType(ISubscriber subscriber, String type);
}

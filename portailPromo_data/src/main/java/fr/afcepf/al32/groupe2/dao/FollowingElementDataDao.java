package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.entity.ISubscriber;


public interface FollowingElementDataDao {
	
	FollowingElementData getOne(Long id);
	
	List<FollowingElementData> getAllByUser(ISubscriber subscriber);
	
	List<FollowingElementData> getAllByUserAndElementType(ISubscriber subscriber, String type);
	
	FollowingElementData save(FollowingElementData fed);
}

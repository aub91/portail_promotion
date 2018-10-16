package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.FollowingElementData;


public interface FollowingElementDataDao {
	List<FollowingElementData> getAllByUser(Long userId);
	
	List<FollowingElementData> getAllByUserAndElementType(Long userId, String type);
	
	FollowingElementData save(FollowingElementData fed);
}

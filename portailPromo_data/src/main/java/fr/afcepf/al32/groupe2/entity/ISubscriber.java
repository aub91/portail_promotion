package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

import fr.afcepf.al32.groupe2.util.FollowableElementType;

public interface ISubscriber {
	void update();
	
	Map<Long, FollowingElementData> getAllFollowableElementData();
	
	Map<Long, FollowingElementData> getAllFollowableElementDataByElementType(FollowableElementType type);

}

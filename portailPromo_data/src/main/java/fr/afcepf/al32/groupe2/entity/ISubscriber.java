package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

public interface ISubscriber {
	void update();
	
	Map<Long, FollowingElementData> getAllFollowableElementData();
	
	Map<Long, FollowingElementData> getAllFollowableElementDataByElementType(String type);

}

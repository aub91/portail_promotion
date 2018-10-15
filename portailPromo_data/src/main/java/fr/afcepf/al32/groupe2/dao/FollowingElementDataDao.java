package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.util.FollowableElementType;

@Component
@Transactional
public interface FollowingElementDataDao {
	List<FollowingElementData> getAllByUser(Long userId);
	
	List<FollowingElementData> getAllByUserAndElementType(Long userId, FollowableElementType type);
	
	FollowingElementData save(FollowingElementData fed);
}

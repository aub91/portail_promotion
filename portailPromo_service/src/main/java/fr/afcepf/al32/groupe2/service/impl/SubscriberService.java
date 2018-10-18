package fr.afcepf.al32.groupe2.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.FollowingElementDataDao;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.entity.IFollowableElement;
import fr.afcepf.al32.groupe2.entity.ISubscriber;
import fr.afcepf.al32.groupe2.service.EmailService;
import fr.afcepf.al32.groupe2.service.ISubscriberService;

@Component
@Transactional
public class SubscriberService implements ISubscriberService{
	
	@Autowired
	private FollowingElementDataDao followingElementDataDao;
	
	@Autowired
	private EmailService emailService;

	@Override
	public void update(ISubscriber subscriber, IFollowableElement element) {
		emailService.sendEmailPromotion((Client) subscriber, element);
	}

	@Override
	public Map<Long, FollowingElementData> getAllFollowableElementData(ISubscriber subscriber) {
		List<FollowingElementData> res = followingElementDataDao.getAllByUser(subscriber);
		return res.stream().collect(Collectors.toMap(FollowingElementData::getId, element -> element));
	}

	@Override
	public Map<Long, FollowingElementData> getAllFollowableElementDataByElementType(ISubscriber subscriber,
			String type) {
		List<FollowingElementData> res = followingElementDataDao.getAllByUserAndElementType(subscriber, type);
		return res.stream().collect(Collectors.toMap(FollowingElementData::getId, element -> element));
	}

}

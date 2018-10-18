package fr.afcepf.al32.groupe2.service;

import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.IFollowableElement;

public interface EmailService {
	void sendEmailPromotion(Client destinataire, IFollowableElement element);
}

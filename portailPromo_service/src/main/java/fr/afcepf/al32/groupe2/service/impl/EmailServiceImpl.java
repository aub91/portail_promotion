package fr.afcepf.al32.groupe2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.IFollowableElement;
import fr.afcepf.al32.groupe2.entity.ReferenceProduct;
import fr.afcepf.al32.groupe2.entity.Shop;
import fr.afcepf.al32.groupe2.service.EmailService;

@Component
public class EmailServiceImpl implements EmailService {
	
	@Autowired
    public JavaMailSender emailSender;
	
	@Override
	public void sendEmailPromotion(Client destinataire, IFollowableElement element) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(destinataire.getEmail()); 
        message.setSubject("Nouvelle Promotion");
        
        if(element instanceof CategoryProduct) {
        	CategoryProduct category = (CategoryProduct) element;
        	message.setText(String.format("Une nouvelle promotion pour la catégorie %s est disponible. Venez nous rendre visite sur www.promo32.fr pour la découvrir.", category.getName()));
        } else if (element instanceof ReferenceProduct) {
        	ReferenceProduct reference = (ReferenceProduct) element;
        	message.setText(String.format("Une nouvelle promotion pour la référence %s est disponible. Venez nous rendre visite sur www.promo32.fr pour la découvrir.", reference.getName()));
		} else if (element instanceof Shop) {
        	Shop shop = (Shop) element;
        	message.setText(String.format("Une nouvelle promotion est disponible chez le commerce %s. Venez nous rendre visite sur www.promo32.fr pour la découvrir.", shop.getName()));
		}

        emailSender.send(message);
		
	}

}

package fr.afcepf.al32.groupe2.service.impl;

import fr.afcepf.al32.groupe2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.service.EmailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {
	
	@Autowired
    public JavaMailSender emailSender;
	
	@Override
	public void sendEmailPromotion(Client destinataire, IFollowableElement element) {

		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			String text = null;

			if(element instanceof CategoryProduct) {
				CategoryProduct category = (CategoryProduct) element;
				text = String.format("Une nouvelle promotion pour la catégorie %s est disponible. Venez nous rendre visite sur www.promo32.fr pour la découvrir.", category.getName());
			} else if (element instanceof ReferenceProduct) {
				ReferenceProduct reference = (ReferenceProduct) element;
				text = String.format("Une nouvelle promotion pour la référence %s est disponible. Venez nous rendre visite sur www.promo32.fr pour la découvrir.", reference.getName());

			} else if (element instanceof Shop) {
				Shop shop = (Shop) element;
				text = String.format("Une nouvelle promotion est disponible chez le commerce %s. Venez nous rendre visite sur www.promo32.fr pour la découvrir.", shop.getName());
			}

			mimeMessage.setContent(getEmailForNewPromotion(destinataire, text), "text/html");
			helper.setTo(destinataire.getEmail());
			helper.setSubject("Nouvelle promotion");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		emailSender.send(mimeMessage);
		
	}

	@Override
	public void sendEmailReservation(Client destinataire, Reservation reservation) {

		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			String htmlMsg = getEmailForReservationConfirmation(destinataire, reservation);
			mimeMessage.setContent(htmlMsg, "text/html");
			helper.setTo(destinataire.getEmail());
			helper.setSubject("Confirmation de réservation");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		emailSender.send(mimeMessage);
	}

	private String getEmailForReservationConfirmation(Client destinataire, Reservation reservation){
		String template = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
				"<head>\n" +
				"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
				"    <meta name=\"viewport\" content=\"width=device-width\"/>\n" +
				"\n" +
				"    <!-- For development, pass document through inliner -->\n" +
				"    <link rel=\"stylesheet\" href=\"css/simple.css\">\n" +
				"\n" +
				"    <style type=\"text/css\">\n" +
				"    * { margin: 0; padding: 0; font-size: 100%%; font-family: 'Avenir Next', \"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif; line-height: 1.65; }\n" +
				"\n" +
				"img { max-width: 100%%; margin: 0 auto; display: block; }\n" +
				"\n" +
				"body, .body-wrap { width: 100%% !important; height: 100%%; background: #f8f8f8; }\n" +
				"\n" +
				"a { color: #71bc37; text-decoration: none; }\n" +
				"\n" +
				"a:hover { text-decoration: underline; }\n" +
				"\n" +
				".text-center { text-align: center; }\n" +
				"\n" +
				".text-right { text-align: right; }\n" +
				"\n" +
				".text-left { text-align: left; }\n" +
				"\n" +
				".button { display: inline-block; color: white; background: #71bc37; border: solid #71bc37; border-width: 10px 20px 8px; font-weight: bold; border-radius: 4px; }\n" +
				"\n" +
				".button:hover { text-decoration: none; }\n" +
				"\n" +
				"h1, h2, h3, h4, h5, h6 { margin-bottom: 20px; line-height: 1.25; }\n" +
				"\n" +
				"h1 { font-size: 32px; }\n" +
				"\n" +
				"h2 { font-size: 28px; }\n" +
				"\n" +
				"h3 { font-size: 24px; }\n" +
				"\n" +
				"h4 { font-size: 20px; }\n" +
				"\n" +
				"h5 { font-size: 16px; }\n" +
				"\n" +
				"p, ul, ol { font-size: 16px; font-weight: normal; margin-bottom: 20px; }\n" +
				"\n" +
				".container { display: block !important; clear: both !important; margin: 0 auto !important; max-width: 580px !important; }\n" +
				"\n" +
				".container table { width: 100%% !important; border-collapse: collapse; }\n" +
				"\n" +
				".container .masthead { padding: 80px 0; background: #008080; color: white; }\n" +
				"\n" +
				".container .masthead h1 { margin: 0 auto !important; max-width: 90%%; text-transform: uppercase; }\n" +
				"\n" +
				".container .content { background: white; padding: 30px 35px; }\n" +
				"\n" +
				".container .content.footer { background: none; }\n" +
				"\n" +
				".container .content.footer p { margin-bottom: 0; color: #888; text-align: center; font-size: 14px; }\n" +
				"\n" +
				".container .content.footer a { color: #888; text-decoration: none; font-weight: bold; }\n" +
				"\n" +
				".container .content.footer a:hover { text-decoration: underline; }" +
				"    </style>\n" +
				"</head>\n" +
				"<body>\n" +
				"<table class=\"body-wrap\">\n" +
				"    <tr>\n" +
				"        <td class=\"container\">\n" +
				"\n" +
				"            <!-- Message start -->\n" +
				"            <table>\n" +
				"                <tr>\n" +
				"                    <td align=\"center\" class=\"masthead\">\n" +
				"\n" +
				"                        <h1>Confirmation de réservation</h1>\n" +
				"\n" +
				"                    </td>\n" +
				"                </tr>\n" +
				"                <tr>\n" +
				"                    <td class=\"content\">\n" +
				"\n" +
				"                        <h2>Bonjour %s,</h2>\n" +
				"\n" +
				"                        <p>Promo 32 vous confirme la réservation n° %d du %tD concernant le produit %s.\nVotre code de retrait est %s.</p>\n" +
				"\n" +
				"                    </td>\n" +
				"                </tr>\n" +
				"            </table>\n" +
				"\n" +
				"        </td>\n" +
				"    </tr>\n" +
				"</table>\n" +
				"</body>\n" +
				"</html>";

		return String.format(template, destinataire.getFirstName(), reservation.getId(), reservation.getDateCreation(), reservation.getReservationProduct().getPromotion().getBaseProduct().getReferenceProduct().getName(), reservation.getWithdrawalCode());
	}

	private String getEmailForNewPromotion(Client destinataire, String text){
		String template = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
				"<head>\n" +
				"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
				"    <meta name=\"viewport\" content=\"width=device-width\"/>\n" +
				"\n" +
				"    <!-- For development, pass document through inliner -->\n" +
				"    <link rel=\"stylesheet\" href=\"css/simple.css\">\n" +
				"\n" +
				"    <style type=\"text/css\">\n" +
				"    * { margin: 0; padding: 0; font-size: 100%%; font-family: 'Avenir Next', \"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif; line-height: 1.65; }\n" +
				"\n" +
				"img { max-width: 100%%; margin: 0 auto; display: block; }\n" +
				"\n" +
				"body, .body-wrap { width: 100%% !important; height: 100%%; background: #f8f8f8; }\n" +
				"\n" +
				"a { color: #71bc37; text-decoration: none; }\n" +
				"\n" +
				"a:hover { text-decoration: underline; }\n" +
				"\n" +
				".text-center { text-align: center; }\n" +
				"\n" +
				".text-right { text-align: right; }\n" +
				"\n" +
				".text-left { text-align: left; }\n" +
				"\n" +
				".button { display: inline-block; color: white; background: #71bc37; border: solid #71bc37; border-width: 10px 20px 8px; font-weight: bold; border-radius: 4px; }\n" +
				"\n" +
				".button:hover { text-decoration: none; }\n" +
				"\n" +
				"h1, h2, h3, h4, h5, h6 { margin-bottom: 20px; line-height: 1.25; }\n" +
				"\n" +
				"h1 { font-size: 32px; }\n" +
				"\n" +
				"h2 { font-size: 28px; }\n" +
				"\n" +
				"h3 { font-size: 24px; }\n" +
				"\n" +
				"h4 { font-size: 20px; }\n" +
				"\n" +
				"h5 { font-size: 16px; }\n" +
				"\n" +
				"p, ul, ol { font-size: 16px; font-weight: normal; margin-bottom: 20px; }\n" +
				"\n" +
				".container { display: block !important; clear: both !important; margin: 0 auto !important; max-width: 580px !important; }\n" +
				"\n" +
				".container table { width: 100%% !important; border-collapse: collapse; }\n" +
				"\n" +
				".container .masthead { padding: 80px 0; background: #008080; color: white; }\n" +
				"\n" +
				".container .masthead h1 { margin: 0 auto !important; max-width: 90%%; text-transform: uppercase; }\n" +
				"\n" +
				".container .content { background: white; padding: 30px 35px; }\n" +
				"\n" +
				".container .content.footer { background: none; }\n" +
				"\n" +
				".container .content.footer p { margin-bottom: 0; color: #888; text-align: center; font-size: 14px; }\n" +
				"\n" +
				".container .content.footer a { color: #888; text-decoration: none; font-weight: bold; }\n" +
				"\n" +
				".container .content.footer a:hover { text-decoration: underline; }" +
				"    </style>\n" +
				"</head>\n" +
				"<body>\n" +
				"<table class=\"body-wrap\">\n" +
				"    <tr>\n" +
				"        <td class=\"container\">\n" +
				"\n" +
				"            <!-- Message start -->\n" +
				"            <table>\n" +
				"                <tr>\n" +
				"                    <td align=\"center\" class=\"masthead\">\n" +
				"\n" +
				"                        <h1>Nouvelle Promotion</h1>\n" +
				"\n" +
				"                    </td>\n" +
				"                </tr>\n" +
				"                <tr>\n" +
				"                    <td class=\"content\">\n" +
				"\n" +
				"                        <h2>Bonjour %s,</h2>\n" +
				"\n" +
				"                        <p>%s</p>\n" +
				"\n" +
				"                    </td>\n" +
				"                </tr>\n" +
				"            </table>\n" +
				"\n" +
				"        </td>\n" +
				"    </tr>\n" +
				"</table>\n" +
				"</body>\n" +
				"</html>";

		return String.format(template, destinataire.getFirstName(), text);
	}

}

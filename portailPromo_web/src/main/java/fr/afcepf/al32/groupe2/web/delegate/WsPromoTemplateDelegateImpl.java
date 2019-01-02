package fr.afcepf.al32.groupe2.web.delegate;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al32.groupe2.ws.itf.IWsPromoTemplate;
import fr.afcepf.al32.groupe2.ws.wsPromoTemplate.dto.TopPromotionTemplateResultDto;

@Component
public class WsPromoTemplateDelegateImpl implements IWsPromoTemplate {

	private RestTemplate restTemplate;
	private String base_url;
	private String base_url_client;

	public WsPromoTemplateDelegateImpl() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream inputStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("web_services.properties");
			props.load(inputStream);
			inputStream.close();

			this.base_url = props.getProperty("ws_promo_template.base_url");
			this.base_url_client = props.getProperty("ws_promo_recom_client.base_url");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public TopPromotionTemplateResultDto searchTopTemplatePromoForShopKeeper(Double sourceLong, Double sourceLat,
			List<String> categories) {
		StringJoiner categoriesJoiner = new StringJoiner(",");
		categories.forEach(word -> {
			try {
				categoriesJoiner.add(URLEncoder.encode(word, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		});
		String url = String.format("%s/ByShopper?sourceLong=%s&sourceLat=%s&categories=%s", base_url, sourceLong,
				sourceLat, categoriesJoiner.toString());

		TopPromotionTemplateResultDto result = null;

		try {
			result = restTemplate.getForObject(url, TopPromotionTemplateResultDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public TopPromotionTemplateResultDto searchByClientsFavoriteCategory(Double sourceLong, Double sourceLat,
			String category) {
		String categoryDecoded = null;
		try {
			categoryDecoded = URLEncoder.encode(category, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String url = String.format("%s/ByClient?sourceLong=%s&sourceLat=%s&category=%s", base_url_client, sourceLong,
				sourceLat, categoryDecoded);

		TopPromotionTemplateResultDto result = null;

		try {
			result = restTemplate.getForObject(url, TopPromotionTemplateResultDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}

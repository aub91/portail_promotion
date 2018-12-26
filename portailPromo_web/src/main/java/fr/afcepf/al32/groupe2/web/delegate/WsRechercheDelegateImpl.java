package fr.afcepf.al32.groupe2.web.delegate;

import fr.afcepf.al32.groupe2.ws.dto.CategoryProductDto;
import fr.afcepf.al32.groupe2.ws.dto.OrchestratorResearchDtoResponse;
import fr.afcepf.al32.groupe2.ws.itf.IWsRecherche;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;

@Component
public class WsRechercheDelegateImpl implements IWsRecherche {

    private RestTemplate restTemplate;
    private String base_url;

    public WsRechercheDelegateImpl() {
        restTemplate = new RestTemplate();
        try {
            Properties props = new Properties();
            InputStream inputStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("web_services.properties");
            props.load(inputStream);
            inputStream.close();

            this.base_url = props.getProperty("orchestrateur_recherche.base_url");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrchestratorResearchDtoResponse searchListPromotion(String sourceAddress, Integer perimetre, List<String> keywords, CategoryProductDto categoryProductDto) {
        StringJoiner keywordsJoiner = new StringJoiner(",");
        keywords.forEach(word ->keywordsJoiner.add(word));
        String url = String.format("%s?source=%s&perimetre=%d&categorie=%d&mots=%s", base_url, sourceAddress, perimetre, categoryProductDto == null ? 0 : categoryProductDto.getId(), keywordsJoiner.toString());
        return restTemplate.getForObject(url, OrchestratorResearchDtoResponse.class);
    }
}

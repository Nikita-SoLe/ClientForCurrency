package hadding.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hadding.model.Currency;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Repository
public class RestTemplateImpl implements RestTemplateDAO {
    static final String URL = "http://localhost:8080/currency/";
    static final String URL_all = (URL + "all");
    static RestTemplate restTemplate = new RestTemplate();
    static ObjectMapper objectMapper = new ObjectMapper();
    static String name;

    @Override
    public Map<String, Currency> getAllCurrency() throws JsonProcessingException {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL_all, String.class);
        String jsonString = responseEntity.getBody();
        return objectMapper.readValue(jsonString, new TypeReference<>() {});

    }

    @Override
    public Currency getCurrencyByName(String name) {
        String url = URL + "getByName/" + name;
        return restTemplate.getForEntity(url, Currency.class).getBody();
    }

    @Override
    public Currency getCurrencyById(Integer id) {
        String url = URL + "getById/" + id;
        return restTemplate.getForEntity(url, Currency.class).getBody();
    }

    @Override
    public Map<String, Currency> getSortedCurrencyNatural() throws JsonProcessingException {
        String url = URL + "sortedNatural";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return objectMapper.readValue(responseEntity.getBody(), new TypeReference<>(){});
    }

    @Override
    public Map<String, Currency> getSortedCurrencyReverse() throws JsonProcessingException {
        String url = URL + "sortedReverse";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return objectMapper.readValue(responseEntity.getBody(), new TypeReference<>(){});
    }

    @Override
    public Double convert(Integer id, Long value) {
        String url = URL + "convert/" + id + "/" + value;
        return restTemplate.getForEntity(url, Double.class).getBody();
    }


    @Override
    public String update() {
        String url = URL + "update";
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}

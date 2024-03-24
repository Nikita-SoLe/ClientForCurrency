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
public class RestTempateImpl implements RestTempateDAO {
    static final String URL = "http://localhost:8080/currency/";
    static final String URL_all = (URL + "all");
    static RestTemplate restTemplate = new RestTemplate();
    static ObjectMapper objectMapper = new ObjectMapper();
    static String name;

    @Override
    public Map<String, Currency> getAllCurrency() throws JsonProcessingException {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL_all, String.class);
        String jsonString = responseEntity.getBody();
        Map<String, Currency> map = objectMapper.readValue(jsonString, new TypeReference<Map<String, Currency>>() {});
        return map;

    }

    @Override
    public String getCurrencyByName(String name) {
        String url = URL + "getByName/" + name;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();
    }

    @Override
    public String getCurrencyById(Integer id) {
        String url = URL + "getById/" + id;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();
    }

    @Override
    public Map<String, Currency> getSortedCurrencyNatural() throws JsonProcessingException {
        String url = URL + "sortedNatural";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        Map<String, Currency> map = objectMapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, Currency>>() {});
        return map;
    }

    @Override
    public Map<String, Currency> getSortedCurrencyReverse() throws JsonProcessingException {
        String url = URL + "sortedReverse";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        Map<String, Currency> map = objectMapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, Currency>>() {});
        return map;
    }

    @Override
    public String convert(Integer id, Long value) {
        String url = URL + "convert/" + id + "/" + value;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();
    }


    @Override
    public String update() {
        String url = URL + "update";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }
}

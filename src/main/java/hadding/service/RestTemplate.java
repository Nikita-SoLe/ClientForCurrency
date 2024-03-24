package hadding.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import hadding.Model.Currency;

import java.util.Map;

public interface RestTemplate {
    Map<String, Currency> getAllCurrency() throws JsonProcessingException;

    String getCurrencyByName(String currency);

    String getCurrencyById(Integer id);

    Map<String, Currency> getSortedCurrencyNatural() throws JsonProcessingException;

    public Map<String, Currency> getSortedCurrencyReverse() throws JsonProcessingException;

    String convert(Integer id, Long value);

    String update();

}

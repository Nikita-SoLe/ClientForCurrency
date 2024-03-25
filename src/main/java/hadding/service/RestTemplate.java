package hadding.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import hadding.model.Currency;

import java.util.Map;

public interface RestTemplate {
    Map<String, Currency> getAllCurrency() throws JsonProcessingException;

    Currency getCurrencyByName(String currency);

    Currency getCurrencyById(Integer id);

    Map<String, Currency> getSortedCurrencyNatural() throws JsonProcessingException;

    public Map<String, Currency> getSortedCurrencyReverse() throws JsonProcessingException;

    Double convert(Integer id, Long value);

    String update();

}

package hadding.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import hadding.model.Currency;

import java.util.Map;

public interface RestTemplateDAO {

    Map<String, Currency> getAllCurrency() throws JsonProcessingException;

    Currency getCurrencyByName(String currency);

    Currency getCurrencyById(Integer id);

    Map<String, Currency> getSortedCurrencyNatural() throws JsonProcessingException;

    Map<String, Currency> getSortedCurrencyReverse() throws JsonProcessingException;

    Double convert(Integer id, Long value);

    String update();


}

package hadding.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import hadding.Model.Currency;

import java.util.Map;

public interface RestTempateDAO {

    Map<String, Currency> getAllCurrency() throws JsonProcessingException;

    String getCurrencyByName(String currency);

    String getCurrencyById(Integer id);

    Map<String, Currency> getSortedCurrencyNatural() throws JsonProcessingException;

    Map<String, Currency> getSortedCurrencyReverse() throws JsonProcessingException;

    String convert(Integer id, Long value);

    String update();


}

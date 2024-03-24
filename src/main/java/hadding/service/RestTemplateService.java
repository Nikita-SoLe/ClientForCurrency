package hadding.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import hadding.model.Currency;
import hadding.dao.RestTempateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RestTemplateService implements RestTemplate{

    @Autowired
    private final RestTempateDAO service;

    public RestTemplateService(RestTempateDAO service) {
        this.service = service;
    }


    @Override
    public Map<String, Currency> getAllCurrency() throws JsonProcessingException {
       return service.getAllCurrency();
    }

    @Override
    public String getCurrencyByName(String currency) {
        return service.getCurrencyByName(currency);
    }

    @Override
    public String getCurrencyById(Integer id) {
        return service.getCurrencyById(id);
    }

    @Override
    public Map<String, Currency> getSortedCurrencyNatural() throws JsonProcessingException {
        return service.getSortedCurrencyNatural();
    }

    @Override
     public Map<String, Currency> getSortedCurrencyReverse() throws JsonProcessingException {
        return service.getSortedCurrencyReverse();
    }

    @Override
    public String convert(Integer id, Long value) {
        return service.convert(id, value);
    }

    @Override
    public String update() {
        return service.update();
    }
}

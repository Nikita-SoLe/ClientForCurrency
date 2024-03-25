package hadding.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import hadding.dao.RestTemplateDAO;
import hadding.model.Currency;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RestTemplateService implements RestTemplate{

    private final RestTemplateDAO service;

    public RestTemplateService(RestTemplateDAO service) {
        this.service = service;
    }


    @Override
    public Map<String, Currency> getAllCurrency() throws JsonProcessingException {
       return service.getAllCurrency();
    }

    @Override
    public Currency getCurrencyByName(String currency) {
        return service.getCurrencyByName(currency);
    }

    @Override
    public Currency getCurrencyById(Integer id) {
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
    public Double convert(Integer id, Long value) {
        return service.convert(id, value);
    }

    @Override
    public String update() {
        return service.update();
    }
}

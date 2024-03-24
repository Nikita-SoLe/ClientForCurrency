package hadding.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import hadding.Model.Currency;
import hadding.service.RestTemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Map;

@Controller
@RequestMapping("/currency")
public class CurrencyController {


    private final RestTemplateService service;

    public CurrencyController(RestTemplateService service) {
        this.service = service;
    }


    @GetMapping("/all")
    public String getAllCurrency(Model model) throws JsonProcessingException {
        Map<String, Currency> currencyMap = service.getAllCurrency();
        model.addAttribute("AllCurrency", currencyMap.values());
        return "all-currency";
    }

    @GetMapping("/sortedNatural")
    public String getSortedNatural(Model model) throws JsonProcessingException {
        Map<String, Currency> currencyMap = service.getSortedCurrencyNatural();
        model.addAttribute("AllCurrency", currencyMap.values());
        return "all-currency";
    }

    @GetMapping("/sortedReverse")
    public String getSortedReverse(Model model) throws JsonProcessingException {

        Map<String, Currency> currencyMap = service.getSortedCurrencyReverse();
        model.addAttribute("AllCurrency", currencyMap.values());
        return "all-currency";
    }

}

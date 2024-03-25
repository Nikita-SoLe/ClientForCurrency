package hadding.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import hadding.model.Currency;
import hadding.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

@Controller
@RequestMapping("/currency")
@Slf4j
public class CurrencyController {
    private final RestTemplateService service;

    public CurrencyController(RestTemplateService service) {
        this.service = service;
    }


    @GetMapping("/all")
    public String getAllCurrency(Model model) throws JsonProcessingException {
        model.addAttribute("AllCurrency", service.getAllCurrency().values());
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
        model.addAttribute("AllCurrency", service.getSortedCurrencyReverse().values());
        return "all-currency";
    }

    @GetMapping("/getCurrencyByName")
    public Currency getCurrencyByName(String currency) {
        return service.getCurrencyByName(currency);
    }

    @GetMapping("/update")
    public String update(Model model) throws JsonProcessingException {
        service.update();
        model.addAttribute("AllCurrency", service.getAllCurrency().values());
        return "all-currency";
    }

    @GetMapping("/view/{id}")
    public String getCurrencyById(@PathVariable("id") Integer id, Model model) throws JsonProcessingException {
        log.info(id.toString());
        model.addAttribute("Currency", service.getCurrencyById(id));
        model.addAttribute("convertedAmount", 0);
        return "view";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam("id") Integer id,
                          @RequestParam("amount") Long amount,
                          Model model) throws JsonProcessingException {
        model.addAttribute("Currency", service.getCurrencyById(id));
        String convert = String.format("%.2f", service.convert(id, amount));
        model.addAttribute("convertedAmount", convert);
        return "view";
    }
    @GetMapping("/back")
    public String convert() throws JsonProcessingException {
        return "redirect:/currency/all";
    }

}

package com.theswdeveloper.currenciesApi.controller;

import com.theswdeveloper.currenciesApi.modelObjects.Currency;
import com.theswdeveloper.currenciesApi.service.CurrencyService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/")
@RestController
public class CurrencyController {

    private CurrencyService currencyService = new CurrencyService();

    public CurrencyController() throws SQLException {

    }

    @GetMapping(path = "healthCheck")
    public String healthCheck() {
        return "currency service is up";
    }

    @GetMapping(path = "getDummyCurrencies")
    public List<Currency> getDummyCoins() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("USD", 1));
        currencies.add(new Currency("EURO", 1.2));
        currencies.add(new Currency("AUD", 1.5));
        currencies.add(new Currency("BGP", 0.8));

        return currencies;
    }

    @GetMapping(path = "getAllCurrencies")
    public List<Currency> getAllCurrencies() throws Exception {
        List<Currency> allCurrencies = currencyService.getAllCurrencies();
        return allCurrencies;
    }

    @PostMapping(path = "addCurrency", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCurrency(@RequestBody Currency currency) throws Exception {
        currencyService.addCurrency(currency);
    }

}

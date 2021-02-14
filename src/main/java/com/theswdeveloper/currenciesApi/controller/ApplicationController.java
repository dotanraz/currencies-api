package com.theswdeveloper.currenciesApi.controller;

import com.theswdeveloper.currenciesApi.ModelObjects.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/")
@RestController
public class ApplicationController {

    @Autowired
    public ApplicationController() {

    }

    @GetMapping(path = "healthCheck")
    public String hello() {
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
    }

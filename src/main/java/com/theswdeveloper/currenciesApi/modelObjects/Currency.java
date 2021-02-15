package com.theswdeveloper.currenciesApi.modelObjects;

public class Currency {

    String currencyName;
    double price;

    public Currency(String currencyName, double price) {
        this.currencyName = currencyName;
        this.price = price;
    }

    public Currency(String currencyName) {
        this.currencyName = currencyName;
    }

    public Currency() {

    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
